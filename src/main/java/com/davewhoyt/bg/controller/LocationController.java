package com.davewhoyt.bg.controller;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.service.LocationService;
import com.davewhoyt.bg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by david on 11/10/15.
 */
@Controller()
@RequestMapping(value="/location")
public class LocationController {

    @Autowired
    private UserService userService;

    private LocationService locationService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createLocation(@CookieValue(value = "userName") String userName, @RequestBody Location location) {
        Member member = userService.findByUserName(userName);
        locationService.createOrUpdate(location, member);
        return "/";
    }

    @RequestMapping("list")
    public List<Location> listAll() {
        return locationService.listAll();
    }


    @RequestMapping(value = "near/{latitude}/{longitude}/{radiusInMeters}", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> listNear(@PathVariable("latitude") Double latitude,
                                   @PathVariable("longitude") Double longitude,
                                   @PathVariable("radiusInMeters") Integer radusInMeters) {

//        Double lat = Double.parseDouble(latitude);
//        Double lon = Double.parseDouble(longitude);
//        Integer rad = Integer.parseInt(radusInMeters);
        return locationService.findNearLatitudeAndLongitude(
                BigDecimal.valueOf(latitude),
                BigDecimal.valueOf(longitude),
                radusInMeters, 0, 100);
    }


    @Inject
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }
}
