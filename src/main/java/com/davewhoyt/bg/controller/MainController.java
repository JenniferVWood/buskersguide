package com.davewhoyt.bg.controller;

import com.davewhoyt.bg.common.Logging;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by david on 11/10/15.
 */
@Controller
public class MainController implements Logging {
    @RequestMapping("/")
    public String renderIndexPage(@CookieValue(value = "userName") String userName, Model model) {
        getLogger().debug("serving index page");

        model.addAttribute("userName", userName);
        return "index";
    }
}
