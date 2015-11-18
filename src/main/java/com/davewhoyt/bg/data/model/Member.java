package com.davewhoyt.bg.data.model;

import com.davewhoyt.bg.common.Logging;

import javax.persistence.*;

/**
 * Created by david on 11/10/15.
 */
@Entity(name = "member")
public class Member implements Logging {

    @Id
    @GeneratedValue(generator="user_seq")
    @SequenceGenerator(name="user_seq", sequenceName = "member_userid_seq")
    @Column(name="userid")
    private Long userId;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        getLogger().debug("userName: userName");
        this.userName = userName;
    }
}
