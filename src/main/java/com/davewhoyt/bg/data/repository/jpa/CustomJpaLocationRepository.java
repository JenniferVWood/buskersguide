package com.davewhoyt.bg.data.repository.jpa;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.repository.CustomLocationRepository;
import com.davewhoyt.bg.data.repository.LocationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * I'm not super happy with this strategy -- very verbose and annotation heavy.
 * We might be better off using a JDBC RowMapper implementation instead of Hibernate/JPA.
 * However, CrudRepository is really useful for a lot of the app, and I don't like to mix
 * Hibernate with non-Hibernate.
 *
 * In the end, this might be solved by storing the cached computed value in the Location table.
 */
@Repository
public class CustomJpaLocationRepository implements CustomLocationRepository {
    private static final String RESULT_SET_MAPPING = "LocationMapping";

    private static final String BASE_QUERY = "select\n" +
            "  location.locationid\n" +
            "  , location.name\n" +
            "  , location.latitude\n" +
            "  , location.longitude\n" +
            "  , avg(rating.value) as \"averagerating\"\n" +
            "  , 0 as distanceinmeters\n" +
            "from location\n" +
            "  inner join rating on location.locationid = rating.locationid\n" ;

    private static final String GROUP_BY = "\n group by location.locationid";


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Location findByLocationId(Long locationId) {
        String sql = BASE_QUERY
                + " where location.locationId  = ?"
                + GROUP_BY;

        Query q = entityManager.createNativeQuery(sql, RESULT_SET_MAPPING);
        q.setParameter(1, locationId);
        return returnSingle(q);
    }


    // TODO: rename to (and make it work like) 'findNearLatitudeAndLongitude(...)'
    @Override
    public Location findByLatitudeAndLongitude(BigDecimal latitude, BigDecimal longitude) {
        assert latitude != null && longitude != null;

        String sql = BASE_QUERY
                + " where location.latitude  = ?"
                + " and location.longitude = ?"
                + GROUP_BY;

        Query q = entityManager.createNativeQuery(sql, RESULT_SET_MAPPING);
        q.setParameter(1, latitude);
        q.setParameter(1, longitude);
        return returnSingle(q);
    }

    @Override
    public List<Location> list(int offset, int limit) {
        String sql = BASE_QUERY
                + GROUP_BY
                + " order by distanceinmeters"
                + " offset ?"
                + " limit ?";

        Query q = entityManager.createNativeQuery(sql, RESULT_SET_MAPPING);
        q.setParameter(1, offset);
        q.setParameter(2, limit);
        return returnList(q);
    }



    /*
    http://gis.stackexchange.com/questions/41242/how-to-find-the-nearest-point-from-poi-in-postgis
      */


    @Override
    public List<Location> findNearLatitudeAndLongitude(BigDecimal latitude, BigDecimal longitude, Integer radiusInMeters, int offset, int limit) {

        // TODO: Do we want to make this the default query? As in, always return distance to [here]?
        String sql = "with\n" +
                "    poi as (\n" +
                "      select st_makepoint(?, ?) as poi\n" +
                "  ),\n" +
                "    near_me as (\n" +
                "      SELECT locationid\n" +
                "        , st_distance(geog, poi.poi) as distanceinmeters\n" +
                "      FROM location, poi\n" +
                "      WHERE st_dwithin(geog, poi.poi, ?)\n" +
                "  )\n" +
                "select\n" +
                "  location.locationid\n" +
                "  , location.name\n" +
                "  , location.latitude\n" +
                "  , location.longitude\n" +
                "  , near_me.distanceinmeters\n" +
                "  , avg(rating.value) as averageRating\n" +
                "\n" +
                "from location\n" +
                "  inner join near_me on near_me.locationid = location.locationid\n" +
                "  inner join rating on location.locationid = rating.locationid\n" +
                "\n" +
                "group by location.locationid, near_me.distanceinmeters\n" +
                "order by near_me.distanceinmeters" +
                " offset ? limit ?"
                ;
        Query q = entityManager.createNativeQuery(sql, RESULT_SET_MAPPING);
        q.setParameter(1, longitude); // st_makepoint has latitude first, to honor "x,y" coord convention.
        q.setParameter(2, latitude);// st_makepoint has latitude first, to honor "x,y" coord convention.
        q.setParameter(3, radiusInMeters);
        q.setParameter(4, offset);
        q.setParameter(5, limit);


        List<Location> ret = new ArrayList<>();

        List<Object[]> results = (List<Object[]>)q.getResultList();

        // TODO: this is very similar to the convenience method below.
        // pretty sure we could do this with stream()...each()...map()...collect()
        results.stream().forEach((record) -> {
            Location l = (Location)record[0];
            Double average = (Double)record[1];
            Double distanceInMeters = (Double)record[2];
            l.setAverageRating(average);
            l.setDistanceInMeters(distanceInMeters);
            ret.add(l);
        });

        return ret;
    }


    // convenience functions to handle the funky mapping above

    private Location returnSingle(Query q) {
        List<Object[]> results = q.getResultList();
        if (results == null || results.size() == 0) return null;

        Location location = (Location) results.get(0)[0];
        location.setAverageRating((Double) results.get(0)[1]);

        Double distanceInMeters = (Double)results.get(0)[2];
        location.setDistanceInMeters(distanceInMeters);
        return location;
    }

    private List<Location> returnList(Query q) {
        List<Location> ret = new ArrayList<Location>();
        List<Object[]> results = q.getResultList();

        // pretty sure we could do this with stream()...each()...map()...collect()
        results.forEach((record) -> {
            Location l = (Location)record[0];
            Double average = (Double)record[1];
            l.setAverageRating(average);
            ret.add(l);
        });

        return ret;
    }
}
