package com.davewhoyt.bg.controller.display;

import com.davewhoyt.bg.common.Logging;
import com.davewhoyt.bg.data.model.Location;
import com.davewhoyt.bg.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by david on 11/27/15.
 */
@Controller("locationViewController")
@RequestMapping("/render/location")
public class LocationController {
    @RequestMapping(value = "detail/{locationId}")
    public String renderDetailsPage(@CookieValue(value = "userName") String userName, Model model
            , @PathVariable("locationId") Long locationId) {
        model.addAttribute("userName", userName);
        model.addAttribute("display", "detail");
        return "/";
    }

}
