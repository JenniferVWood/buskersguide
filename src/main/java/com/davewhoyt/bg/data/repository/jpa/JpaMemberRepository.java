package com.davewhoyt.bg.data.repository.jpa;
import com.davewhoyt.bg.data.model.Member;
import com.davewhoyt.bg.data.repository.MemberRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Persistence layer for <code>Member</code>s.
 *
 */
@Repository
public interface JpaMemberRepository extends CrudRepository<Member, Long>, MemberRepository {

    /**
     * Find the user with the given username.
     *
     * @param userName
     * @return the matching Member, or Null.
     */
    Member findByUserName(String userName);

}
