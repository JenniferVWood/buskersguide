package com.davewhoyt.bg.service;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.data.model.Rating;
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
     * @param member
     * @return the new or updated ReadWriteLocation
     */
    @Transactional
    public Location createOrUpdate(Location location, Member member) {
        Location previousLocation =  locationRepository.findByLatitudeAndLongitude(location.getLatitude(), location.getLongitude());

        if (previousLocation != null) {
            Rating previousRating = ratingRepository.findByLocationAndMember(previousLocation, member);
            if (previousRating != null) {
                previousRating.setValue(location.getRating());
                Rating r = ratingRepository.save(previousRating);
            } else {
                Rating r = ratingService.createForLocationAndMember(previousLocation, member, location.getRating());
            }
            return previousLocation;

        } else {
           Rating r = ratingService.createForLocationAndMember(location, member, location.getRating());
        }
        return locationRepository.save(location);
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
