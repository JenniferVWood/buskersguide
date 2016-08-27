package com.davewhoyt.bg.data.repository;

import com.davewhoyt.bg.data.model.Invite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InviteRepository extends CrudRepository<Invite, String> {

    public List<Invite> findByUserId(Long userId);


    @Query("select i from invite i where i.grantedTo is null and i.userId = :userId")
    public List<Invite> findUnusedByUserId(@Param("userId") Long userId);
}
