package com.davewhoyt.bg.data.repository.jpa;
import com.davewhoyt.bg.data.model.User;
import com.davewhoyt.bg.data.repository.UserRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Persistence layer for <code>User</code>s.
 *
 */
@Repository
public interface JpaUserRepository extends CrudRepository<User, Long>, UserRepository {

    /**
     * Find the user with the given username.
     *
     * @param userName
     * @return the matching User, or Null.
     */
    User findByUserName(String userName);

}
