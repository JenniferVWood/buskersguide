package com.davewhoyt.bg.service;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.model.Rating;
import com.davewhoyt.bg.data.repository.jpa.JpaRatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by david on 11/11/15.
 */
@Service
public class RatingService {

    private JpaRatingRepository ratingRepository;

    @Transactional
    public Rating findByLocationAndUser(Location location, User user) {
        return ratingRepository.findByLocationAndUser(location, user);
    }

    @Transactional
    public Rating createForLocationAndUser(Location location, User user, Integer value) {
        double roundedLat = BigDecimal.valueOf(location.getLatitude()).setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        double roundedLong = BigDecimal.valueOf(location.getLongitude()).setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        Rating rating = new Rating();
        rating.setUser(user);
        rating.setValue(value);
        rating.setLocation(location);
        ratingRepository.save(rating);
        return rating;
    }

    @Inject
    public void setRatingRepository(JpaRatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
}
