package com.davewhoyt.bg.controller.display;

import com.davewhoyt.bg.common.Logging;
import com.davewhoyt.bg.data.model.Invite;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.service.InviteService;
import com.davewhoyt.bg.service.UserService;
import com.davewhoyt.bg.spring.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController implements Logging {

    @Autowired
    UserService userService;


    @RequestMapping("/admin/create")
    public String renderAddUserForm() {
        getLogger().info("Rendering 'add user' template.");
        return "/addUser";
    }


    @RequestMapping("")
    public String renderUserProfile(Principal principal, Model model) {
        getLogger().debug("Rendering 'user profile' template");

        User user = userService.findByUserName(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("roles", SecurityUtils.listRoles());
        model.addAttribute("isAdmin", SecurityUtils.hasRole("ADMIN"));

        return "/user";
    }


}
