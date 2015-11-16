package com.davewhoyt.bg.service;

import com.davewhoyt.bg.common.exception.NoSuchUserException;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.data.repository.jpa.JpaMemberRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Manage business logic around CRUD of Users.
 *
 * We may not actually have any special logic here -- most of what we need is defined in DB Unique constraints.
 */
@Service("userService")
public class UserService {

    private JpaMemberRepository userRepository;

    public Member createUser(String userName) {
        Member member = new Member();
        member.setUserName(userName);
        return userRepository.save(member);
    }

    public Member findByUserName(String userName) throws NoSuchUserException {
        Member member = userRepository.findByUserName(userName);
        if (member == null) {
            throw new NoSuchUserException();
        }
        return member;
    }
    @Inject
    public void setUserRepository(JpaMemberRepository userRepository) {
        this.userRepository = userRepository;
    }
}
