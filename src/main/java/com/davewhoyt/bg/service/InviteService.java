package com.davewhoyt.bg.service;


import com.davewhoyt.bg.common.exception.InvalidInviteException;
import com.davewhoyt.bg.data.model.Invite;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.repository.InviteRepository;
import com.davewhoyt.bg.data.repository.UserRepository;
import com.davewhoyt.bg.data.repository.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("inviteService")
public class InviteService {


    @Autowired private InviteRepository inviteRepo;
    @Autowired private UserService userService;

    public List<String> getRemainingInvitesFor(User user) {
        List<String> invites =  inviteRepo.findUnusedByUserId(user.getUserId())
                .stream()
        .map(Invite::getInviteId)
        .collect(Collectors.toList());

        if (invites.size() == 0) {
            invites = Collections.emptyList();
        }
        return invites;
    }


    public void generateInvitesFor(User user) {

        List<Invite> userInvites = inviteRepo.findByUserId(user.getUserId());

        // TODO: throw some kind of error to provide feedback to the user.
        if (userInvites != null && userInvites.size() > 5) return;

        for (int i = 0; i < 5; i++) {
            Invite invite = new Invite();
            invite.setUserId(user.getUserId());
            inviteRepo.save(invite);
        }
    }

    public boolean validateInvite(String inviteId) {
        boolean valid = false;
        Invite invite = inviteRepo.findOne(inviteId);
        if (invite != null && invite.getGrantedTo() == null) {
            valid = true;
        }
        return valid;
    }


    public void setGrantedTo(String inviteId, User user) {
        Invite invite = inviteRepo.findOne(inviteId);
        invite.setGrantedTo(user.getUserId());
        inviteRepo.save(invite);
    }


    public User createInvitedUser(String inviteId, String userName, String password) throws InvalidInviteException {
        if (!validateInvite(inviteId)) throw new InvalidInviteException();

        User user = userService.createUser(userName, password);
        setGrantedTo(inviteId, user);

        generateInvitesFor(user);

        return user;
    }
}
