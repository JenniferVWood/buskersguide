package com.davewhoyt.bg.service;

import com.davewhoyt.bg.common.exception.NoSuchUserException;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.repository.jpa.JpaUserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Manage business logic around CRUD of Users.
 *
 * We may not actually have any special logic here -- most of what we need is defined in DB Unique constraints.
 */
@Service("customUserService")
public class UserService {

    private JpaUserRepository userRepository;

    public User createUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        return userRepository.save(user);
    }

    public User findByUserName(String userName) throws NoSuchUserException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new NoSuchUserException();
        }
        return user;
    }
    @Inject
    public void setUserRepository(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
