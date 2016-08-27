package com.davewhoyt.bg.service;

import com.davewhoyt.bg.common.exception.NoSuchUserException;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.repository.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manage business logic around CRUD of Users.
 *
 * We may not actually have any special logic here -- most of what we need is defined in DB Unique constraints.
 */
@Service("customUserService")
public class UserService {

    @Autowired
    private DataSource datasource;

    @Autowired private AuthenticationManagerBuilder auth;

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired InviteService inviteService;

    public User createUser(String userName, String password) {
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(datasource);
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        if(!userDetailsService.userExists(userName)) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            org.springframework.security.core.userdetails.User userDetails
                    = new org.springframework.security.core.userdetails
                    .User(userName, encoder.encode(password), authorities);

            userDetailsService.createUser(userDetails);
        }
        return findByUserName(userName);
    }

    public User findByUserName(String userName) throws NoSuchUserException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new NoSuchUserException();
        }
        return user;
    }


    public Map<String, Object> getProfileData(Principal principal) {
        Map<String, Object> userProfile = new HashMap<>();
        User user = findByUserName(principal.getName());

//        userProfile.put("user", user);
        // TODO:  add list of ratings

        userProfile.put("invites", inviteService.getRemainingInvitesFor(user));
        return userProfile;
    }


}
