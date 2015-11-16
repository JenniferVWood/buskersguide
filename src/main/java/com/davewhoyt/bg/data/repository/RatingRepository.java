package com.davewhoyt.bg.data.repository;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.data.model.Rating;

/**
 * Created by david on 11/11/15.
 */
public interface RatingRepository {
     Rating findByLocationAndMember(Location location, Member member);
}
