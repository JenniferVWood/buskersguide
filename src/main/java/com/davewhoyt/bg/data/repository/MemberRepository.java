package com.davewhoyt.bg.data.repository;

import com.davewhoyt.bg.data.model.Member;

/**
 * Persistence layer for <code>Member</code>s.
 *
 */
public interface MemberRepository {

    /**
     * Find the user with the given username.
     *
     * @param userName
     * @return the matching Member, or Null.
     */
    Member findByUserName(String userName);

}
