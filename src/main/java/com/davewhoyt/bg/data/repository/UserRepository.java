package com.davewhoyt.bg.data.repository;

import com.davewhoyt.bg.data.model.User;

/**
 * Persistence layer for <code>User</code>s.
 *
 */
public interface UserRepository {

    /**
     * Find the user with the given username.
     *
     * @param userName
     * @return the matching User, or Null.
     */
    User findByUserName(String userName);

}
