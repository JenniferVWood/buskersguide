package com.davewhoyt.bg.data.repository;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.model.Rating;

/**
 * Created by david on 11/11/15.
 */
public interface RatingRepository {
     Rating findByLocationAndUser(Location location, User user);
}
