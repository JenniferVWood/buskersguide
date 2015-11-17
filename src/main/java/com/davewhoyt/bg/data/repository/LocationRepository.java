package com.davewhoyt.bg.data.repository;

import com.davewhoyt.bg.data.model.Location;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by david on 11/10/15.
 */
public interface LocationRepository {
    Location findByLocationId(Long locationId);

    /**
     *
     * @param latitude
     * @param Longitude
     * @return A List of Longitudes near the given coordinates.
     */
    Location findByLatitudeAndLongitude(BigDecimal latitude, BigDecimal Longitude);

}
