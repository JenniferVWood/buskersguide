package com.davewhoyt.bg.data.repository.jpa;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.data.model.Rating;
import com.davewhoyt.bg.data.repository.RatingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by david on 11/11/15.
 */
@Repository
public interface JpaRatingRepository extends CrudRepository<Rating,Long>, RatingRepository {

    Rating findByLocationAndMember(Location location, Member member);
}
