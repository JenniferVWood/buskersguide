package com.davewhoyt.bg.data.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "invite")
public class Invite {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "inviteid", nullable = false, unique = true)
    private String inviteId;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "grantedto")
    private Long grantedTo;

    public String getInviteId() {
        return inviteId;
    }

    public void setInviteId(String inviteId) {
        this.inviteId = inviteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGrantedTo() {
        return grantedTo;
    }

    public void setGrantedTo(Long grantedTo) {
        this.grantedTo = grantedTo;
    }
}
