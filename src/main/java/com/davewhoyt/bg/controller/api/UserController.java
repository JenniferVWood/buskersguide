package com.davewhoyt.bg.controller.api;

import com.davewhoyt.bg.common.Logging;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.repository.jpa.JpaUserRepository;
import com.davewhoyt.bg.service.InviteService;
import com.davewhoyt.bg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;


@Controller("apiUserController")
@RequestMapping("/api/user")
public class UserController implements Logging {

    @Autowired
    private UserService userService;

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private InviteService inviteService;


    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Map<String, String> userParams,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        userService.createUser(userParams.get("userName"), userParams.get("password"));
        return "OK";
    }


    @RequestMapping("profile")
    public @ResponseBody  Map<String, Object> getProfileData(Principal principal) {
        return userService.getProfileData(principal);
    }


    @RequestMapping(value = "/admin/requestInvites", method = RequestMethod.POST)
    public @ResponseBody String generateInvites(@RequestParam String userName) {
        inviteService.generateInvitesFor(userService.findByUserName(userName));
        return "OK";
    }

}





