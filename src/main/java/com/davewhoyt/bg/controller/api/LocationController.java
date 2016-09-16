package com.davewhoyt.bg.controller.api;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.service.LocationService;
import com.davewhoyt.bg.service.UserService;
import com.davewhoyt.bg.spring.AnonymousUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

/**
 * Created by david on 11/10/15.
 */
@Controller("locationApiController")
@RequestMapping(value="/api/location")
public class LocationController {

    @Autowired
    private UserService userService;

    private LocationService locationService;

    @RequestMapping(value = "rate", method = RequestMethod.POST)
    public String createLocation(Principal principal, @RequestBody Location location) {
        User user = userService.findByUserName(principal.getName());
        locationService.createOrUpdate(location, user);
        return "/";
    }

    @RequestMapping("list")
    public List<Location> listAll() {
        List<Location> ret = locationService.listAll();
        return ret;
    }


    @RequestMapping(value = "near/{latitude}/{longitude}/{radiusInMeters}", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> listNear(@PathVariable("latitude") Double latitude,
                                   @PathVariable("longitude") Double longitude,
                                   @PathVariable("radiusInMeters") Integer radiusInMeters, Principal principal) {


        if (principal instanceof AnonymousUser) {
            return locationService.findNearLatitudeAndLongitude(BigDecimal.valueOf(44.944), BigDecimal.valueOf(-93.268), 10000, 0, 20);
        } else {
            return locationService.findNearLatitudeAndLongitude(
                    BigDecimal.valueOf(latitude),
                    BigDecimal.valueOf(longitude),
                    radiusInMeters, 0, 100);
        }
    }


    @RequestMapping(value = "details/{locationId}")
    @ResponseBody
    public Location details(@PathVariable("locationId") Long locationId) {

        return locationService.findByLocationId(locationId);
    }



    @Inject
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }
}
