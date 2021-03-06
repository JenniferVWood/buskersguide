package com.davewhoyt.bg.service;

import com.davewhoyt.bg.ServerApplication;

import com.davewhoyt.bg.data.model.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
/**
 * Created by david on 11/11/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class LocationServiceTests extends AbstractServiceTest {

    @Test
    public void testNothing() {
        assertTrue(true);
    }
//
//    /**
//     * Test both initial create, and duplicate "create"
//     *
//     * @throws Exception
//     */
//    @Test
//    public void testCreateNewLocation() throws Exception {
//        Location l2 = locationRepository.findByLocationId(this.l1.getLocationId());
//
//        assertEquals("retrieved the same location as saved:", l2.getLocationId(), l1.getLocationId());
//
//        Location dupe = new Location();
//        dupe.setLatitude(BigDecimal.ONE);
//        dupe.setLongitude(BigDecimal.ONE);
//        dupe.setName("dupe"); //should be ignored
//        dupe.setRating(9);
//        dupe = locationService.createOrUpdate(dupe, m2);
//
//        Location orig = locationRepository.findByLocationId(l1.getLocationId());
//        assertEquals("dupe and original have same id:", dupe.getLocationId(), orig.getLocationId());
//    }

//    @Test
//    public void testCreateDuplicateLocationUpdatesExisting() throws Exception {
//
////        assertEquals("orig has new rating: ", orig.getRating().intValue(), 9);
//    }


}

