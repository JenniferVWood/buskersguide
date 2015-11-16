package com.davewhoyt.bg.controller;

import com.davewhoyt.bg.common.Logging;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.data.repository.jpa.JpaMemberRepository;
import com.davewhoyt.bg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by david on 11/10/15.
 */
@Controller
@RequestMapping("/member")
public class UserController implements Logging {

    private UserService userService;
    private JpaMemberRepository userRepository;

    /**
     * Create a new user.
     *
     * @param userName name to use when creating the user
     * @return forward request to <code>destination</code>.
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@RequestParam("userName") String userName,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        Member newMember = userService.createUser(userName);
        Cookie cookie = new Cookie("userName", newMember.getUserName());
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }


    /**
     *
     * @param userName name to log in as
     * @return forward request to <code>destination</code>.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("userName") String userName,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        Member newMember = userService.findByUserName(userName);
        Cookie cookie = new Cookie("userName", newMember.getUserName());
        cookie.setPath("/");
        response.addCookie(cookie);
        getLogger().debug("forwarding to index controller");
        return "redirect:/";
    }



    /**
     * List all the users in the system.  Only for development.
     *
     * @return all the users.
     */
    @RequestMapping("/all")
    public @ResponseBody
    Iterable<Member> findAll(@CookieValue(value = "userName") String userName) {

        return userRepository.findAll();
    }



    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Inject
    public void setUserRepository(JpaMemberRepository userRepository) {
        this.userRepository = userRepository;
    }
}





