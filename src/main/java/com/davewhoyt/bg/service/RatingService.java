package com.davewhoyt.bg.service;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.data.model.Rating;
import com.davewhoyt.bg.data.repository.jpa.JpaRatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by david on 11/11/15.
 */
@Service
public class RatingService {

    private JpaRatingRepository ratingRepository;

    @Transactional
    public Rating findByLocationAndMember(Location location, Member member) {
        return ratingRepository.findByLocationAndMember(location, member);
    }

    @Transactional
    public Rating createForLocationAndMember(Location location, Member member, Integer value) {
        Rating rating = new Rating();
        rating.setMember(member);
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
