package com.davewhoyt.bg.service;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.repository.jpa.JpaLocationRepository;
import com.davewhoyt.bg.data.repository.jpa.JpaRatingRepository;
import com.davewhoyt.bg.data.repository.jpa.JpaUserRepository;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * Created by david on 11/11/15.
 */
@SpringBootTest
public class AbstractServiceTest {
//    @Autowired
//    LocationService locationService;
//
//    @Autowired
//    JpaLocationRepository locationRepository;
//
//    @Autowired UserService userService;
//
//    @Autowired
//    JpaUserRepository userRepository;
//
//    @Autowired
//    JpaRatingRepository ratingRepository;
//
//    public User m1, m2 = null;
//    public Location l1 = null;
//
//    @Before
//    public void setUp() {
//        this.m1 = userService.createUser("user1");
//        this.m2 = userService.createUser("user2");
//        l1 = new Location();
//        l1.setLatitude(BigDecimal.ONE);
//        l1.setLongitude(BigDecimal.ONE);
//        l1.setName("l1");
//        l1.setRating(1);
//
//        l1 = locationService.createOrUpdate(l1, m1);
//
//    }
//
//    @After
//    public void tearDown() {
//        ratingRepository.deleteAll();
//
//        locationRepository.deleteAll();
//        this.l1 = null;
//
//        userRepository.deleteAll();
//        this.m1 = null;
//        this.m2 = null;
//
//    }
}
