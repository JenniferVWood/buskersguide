package com.davewhoyt.bg.data.repository.jpa;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.repository.LocationRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by david on 11/10/15.
 */
@Repository
public interface JpaLocationRepository extends CrudRepository<Location, Long>, LocationRepository {
    Location findByLocationId(Long locationId);
    Location findByLatitudeAndLongitude(Integer latitude, Integer Longitude);

}
