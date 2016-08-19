package com.davewhoyt.bg.controller.display;

import com.davewhoyt.bg.common.Logging;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by david on 8/19/16.
 */
@Controller
@RequestMapping("/user")
public class UserController implements Logging {


    @RequestMapping("create")
    public String renderAddUserForm() {
        getLogger().info("Rendering 'add user' template.");
//        return "/hello.html";
        return "/addUser";
    }
}
