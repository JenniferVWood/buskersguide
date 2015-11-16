package com.davewhoyt.bg.repository;

import com.davewhoyt.bg.ServerApplication;
import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.data.model.Rating;
import com.davewhoyt.bg.data.repository.jpa.CustomJpaLocationRepository;
import com.davewhoyt.bg.data.repository.jpa.JpaLocationRepository;
import com.davewhoyt.bg.data.repository.jpa.JpaRatingRepository;
import com.davewhoyt.bg.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by david on 11/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class CustomJpaLocationRepositoryTest {
    @Autowired
    CustomJpaLocationRepository customJpaLocationRepository;

    @Autowired
    JpaLocationRepository jpaLocationRepository;

    @Autowired
    JpaRatingRepository jpaRatingRepository;

    @Autowired
    UserService userService;

    @Test
    public void testFindOne() {
        Member m1 = userService.createUser("u1");
        Member m2 = userService.createUser("u2");

        // assume that the standard Spring CrudRepository impl works.
        Location l1 = new Location();
        l1.setName("l1");
        l1.setLatitude(1);
        l1.setLongitude(1);
        jpaLocationRepository.save(l1);

        Rating rating = new Rating();
        rating.setValue(2);
        rating.setLocation(l1);
        rating.setMember(m1);
        jpaRatingRepository.save(rating);

        Rating rating2 = new Rating();
        rating2.setLocation(l1);
        rating2.setMember(m2);
        rating2.setValue(1);
        jpaRatingRepository.save(rating2);

        // here we go!
        Location l2 = customJpaLocationRepository.findByLocationId(l1.getLocationId());
        assertNotNull(l2);

        assertEquals(1.0d, l2.getAverageRating(), 0);
    }

    @Test
    public void testListAll() {
        // assume that the standard Spring CrudRepository impl works.
        Member m1 = userService.createUser("u3");

        Location l1 = new Location();
        l1.setName("l1");
        l1.setLatitude(2);
        l1.setLongitude(2);
        jpaLocationRepository.save(l1);

        Rating rating = new Rating();
        rating.setValue(2);
        rating.setMember(m1);
        jpaRatingRepository.save(rating);

        Location l2 = new Location();
        l2.setName("l1");
        l2.setLatitude(2);
        l2.setLongitude(1);
        jpaLocationRepository.save(l1);

        Rating rating2 = new Rating();
        rating2.setLocation(l2);
        rating2.setMember(m1);
        rating2.setValue(1);
        jpaLocationRepository.save(l2);
        jpaRatingRepository.save(rating2);

        List<Location> locations = customJpaLocationRepository.list(0, 100);
        assertEquals("two locations returned: ", 2, locations.size());
    }
}
