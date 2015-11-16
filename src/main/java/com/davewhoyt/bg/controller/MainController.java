package com.davewhoyt.bg.controller;

import com.davewhoyt.bg.common.Logging;
import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by david on 11/10/15.
 */
@Controller
public class MainController implements Logging {
    @Autowired
    LocationService locationService;

    @RequestMapping("/")
    public String renderIndexPage(@CookieValue(value = "userName") String userName, Model model) {
        getLogger().debug("serving index page");

        List<Location> locations = locationService.listAll();

        model.addAttribute("locations", locations);

        model.addAttribute("userName", userName);
        return "index";
    }


}
