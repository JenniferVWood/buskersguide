package com.davewhoyt.bg.controller;

import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.service.LocationService;
import com.davewhoyt.bg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

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

    @Inject
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }
}
