package com.davewhoyt.bg.controller.display;

import com.davewhoyt.bg.common.exception.InvalidInviteException;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.service.InviteService;
import com.davewhoyt.bg.spring.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("inviteController")
@RequestMapping("/invite")
public class InviteController {

    @Autowired
    InviteService inviteService;

    @RequestMapping("{inviteId}")
    public String renderAddInvitedUser(@PathVariable String inviteId, Model model) {

        // TODO: validate invite
        model.addAttribute("inviteId", inviteId);
        model.addAttribute("inviteValid", inviteService.validateInvite(inviteId));
        return "/invitedUser";
    }


    @RequestMapping(value="consume/{inviteId}", method = RequestMethod.POST)
    public String createInvitedUser(@PathVariable String inviteId, @RequestParam String newUserName, @RequestParam String newUserPassword) {
        try {
            User user = inviteService.createInvitedUser(inviteId, newUserName, newUserPassword);
            SecurityUtils.logInUser(user);
            return "redirect:/";
        } catch (Exception e) {
            return "0xDEADBEEF";
        }
    }

}
