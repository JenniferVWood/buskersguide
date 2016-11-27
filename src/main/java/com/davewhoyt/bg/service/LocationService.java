package com.davewhoyt.bg.service;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.model.Rating;
import com.davewhoyt.bg.data.repository.LocationRepository;
import com.davewhoyt.bg.data.repository.jpa.CustomJpaLocationRepository;
import com.davewhoyt.bg.data.repository.jpa.JpaLocationRepository;
import com.davewhoyt.bg.data.repository.jpa.JpaRatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by david on 11/10/15.
 */
@Service("locationService")
public class LocationService {

    private JpaLocationRepository locationRepository;
    private CustomJpaLocationRepository customLocationRepository;
    private JpaRatingRepository ratingRepository;

    private RatingService ratingService;

    /**
     * If the location doesn't exist (by latitude and longitude), rate it and save it.
     * If the location exists, and the user hasn't rated it, then create a new rating for location/user.
     * If the location exists, and the user has already rated it, then update the user's rating for that location.
     *
     * @param location
     * @param user
     * @return the new or updated ReadWriteLocation
     */
    @Transactional
    public Location createOrUpdate(Location location, User user) {
        double roundedLat = BigDecimal.valueOf(location.getLatitude()).setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        double roundedLong = BigDecimal.valueOf(location.getLongitude()).setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        Location previousLocation =  locationRepository.findByLatitudeAndLongitude(roundedLat, roundedLong);

        if (previousLocation != null) {
            Rating previousRating = ratingRepository.findByLocationAndUser(previousLocation, user);
            if (previousRating != null) {
                previousRating.setValue(location.getRating());
                Rating r = ratingRepository.save(previousRating);
            } else {
                Rating r = ratingService.createForLocationAndUser(previousLocation, user, location.getRating());
            }
            return previousLocation;

        } else {
           Rating r = ratingService.createForLocationAndUser(location, user, location.getRating());
        }
        return locationRepository.save(location);
    }

    @Transactional
    public Location findByLocationId(Long locationId) {
        return customLocationRepository.findByLocationId(locationId);
    }



    @Transactional
    public List<Location> listAll() {
        List<Location> ret = customLocationRepository.list(0,100);
        return ret;
    }


    /**
     * This is a potentially expensive operation, though some effort has been made to optimize the query to
     * run the most expensive operations as few times as possible.
     *
     * @param latitude
     * @param longitude
     * @param radiusInMeters
     * @param offset
     * @param limit
     * @return List of Locations that match the specified parameters.
     */
    @Transactional
    public List<Location> findNearLatitudeAndLongitude(BigDecimal latitude, BigDecimal longitude, Integer radiusInMeters, int offset, int limit) {
        return customLocationRepository.findNearLatitudeAndLongitude(latitude,longitude,radiusInMeters,offset,limit);
    }


    @Transactional
    public void updateRating(Long locationId, Integer ratingValue, User user) {
        Location location = customLocationRepository.findByLocationId(locationId);
        Rating rating = new Rating();
        rating.setLocation(location);
        rating.setValue(ratingValue);
        rating.setUser(user);
        ratingRepository.save(rating);
    }


    @Inject
    public void setLocationRepository(JpaLocationRepository r) {
        this.locationRepository = r;

    }

    @Inject
    public void setRatingRepository(JpaRatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Inject
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @Inject
    public void setCustomLocationRepository(CustomJpaLocationRepository customLocationRepository) {
        this.customLocationRepository = customLocationRepository;
    }

}
