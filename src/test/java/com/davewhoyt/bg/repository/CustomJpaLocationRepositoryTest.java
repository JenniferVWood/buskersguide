package com.davewhoyt.bg.repository;

import com.davewhoyt.bg.ServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * (c) buskersguidetotheuniverse.org
 */
@RunWith(SpringRunner.class)
@SpringBootTest( classes = ServerApplication.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class CustomJpaLocationRepositoryTest {
    @Test
    public void testNothing() {
        assertTrue(true);
    }

    //    @Autowired
//    CustomJpaLocationRepository customJpaLocationRepository;
//
//    @Autowired
//    JpaLocationRepository jpaLocationRepository;
//
//    @Autowired
//    JpaRatingRepository jpaRatingRepository;
//
//    @Autowired
//    UserService userService;
//
//    @Test
//    public void testFindOne() {
//        User m1 = userService.createUser("u1");
//        User m2 = userService.createUser("u2");
//
//        // assume that the standard Spring CrudRepository impl works.
//        Location l1 = new Location();
//        l1.setName("l1");
//        l1.setLatitude(BigDecimal.ONE);
//        l1.setLongitude(BigDecimal.ONE);
//        jpaLocationRepository.save(l1);
//
//        Rating rating = new Rating();
//        rating.setValue(2);
//        rating.setLocation(l1);
//        rating.setUser(m1);
//        jpaRatingRepository.save(rating);
//
//        Rating rating2 = new Rating();
//        rating2.setLocation(l1);
//        rating2.setUser(m2);
//        rating2.setValue(1);
//        jpaRatingRepository.save(rating2);
//
//        // here we go!
//        Location l2 = customJpaLocationRepository.findByLocationId(l1.getLocationId());
//        assertNotNull(l2);
//
//        assertEquals(1.0d, l2.getAverageRating(), 0);
//    }
//
//    @Test
//    public void testListAll() {
//        // assume that the standard Spring CrudRepository impl works.
//        User m1 = userService.createUser("u3");
//
//        Location l1 = new Location();
//        l1.setName("l1");
//        l1.setLatitude(BigDecimal.valueOf(2));
//        l1.setLongitude(BigDecimal.valueOf(2));
//        jpaLocationRepository.save(l1);
//
//        Rating rating = new Rating();
//        rating.setValue(2);
//        rating.setUser(m1);
//        jpaRatingRepository.save(rating);
//
//        Location l2 = new Location();
//        l2.setName("l1");
//        l2.setLatitude(BigDecimal.valueOf(2));
//        l2.setLongitude(BigDecimal.valueOf(2));
//        jpaLocationRepository.save(l1);
//
//        Rating rating2 = new Rating();
//        rating2.setLocation(l2);
//        rating2.setUser(m1);
//        rating2.setValue(1);
//        jpaLocationRepository.save(l2);
//        jpaRatingRepository.save(rating2);
//
//        List<Location> locations = customJpaLocationRepository.list(0, 100);
//        assertEquals("two locations returned: ", 2, locations.size());
//    }
}
