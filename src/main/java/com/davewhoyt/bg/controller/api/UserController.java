package com.davewhoyt.bg.controller.api;

import com.davewhoyt.bg.common.Logging;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.repository.jpa.JpaUserRepository;
import com.davewhoyt.bg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by david on 11/10/15.
 */
@Controller("apiUserController")
@RequestMapping("/api/user")
public class UserController implements Logging {

    private UserService userService;
    private JpaUserRepository userRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Map<String, String> userParams,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        userService.createUser(userParams.get("userName"), userParams.get("password"));
        return "OK";
    }




    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Inject
    public void setUserRepository(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}





