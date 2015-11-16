package com.davewhoyt.bg.data.repository.jpa;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.repository.CustomLocationRepository;
import com.davewhoyt.bg.data.repository.LocationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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
            "\n" +
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
    public Location findByLatitudeAndLongitude(Integer latitude, Integer longitude) {
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
                + " limit ?"
                + " offset ?";

        Query q = entityManager.createNativeQuery(sql, RESULT_SET_MAPPING);
        q.setParameter(1, offset);
        q.setParameter(2, limit);
        return (List<Location>)q.getResultList();
    }



    private Location returnSingle(Query q) {
        List<Object[]> results = q.getResultList();
        if (results == null || results.size() == 0) return null;

        Location location = (Location) results.get(0)[0];
        location.setAverageRating((Double) results.get(0)[1]);
        return location;
    }

    private List<Location> returnList(Query q) {
        List<Location> ret = new ArrayList<Location>();
        List<Object[]> results = q.getResultList();

        // pretty sure we could do this with stream()...each()...map()...collect()
        results.stream().forEach((record) -> {
            Location l = (Location)record[0];
            Double average = (Double)record[1];
            l.setAverageRating(average);
            ret.add(l);
        });

        return ret;
    }
}
