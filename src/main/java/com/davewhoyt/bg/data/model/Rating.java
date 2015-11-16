package com.davewhoyt.bg.data.model;

import javax.persistence.*;

/**
 * Created by david on 11/11/15.
 */
@Entity(name="rating")
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"memberid", "locationid", "buskerid"}))
public class Rating {
    @Id
    @GeneratedValue(generator="rating_seq")
    @SequenceGenerator(name="rating_seq", sequenceName = "rating_ratingid_seq")
    @Column(name="ratingid")
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name="memberid")
    private Member member;

    @ManyToOne
    @JoinColumn(name="buskerid")
    private Busker busker;

    @ManyToOne
    @JoinColumn(name="locationid")
    private Location location;

    @Column
    private Integer value;

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Busker getBusker() {
        return busker;
    }

    public void setBusker(Busker busker) {
        this.busker = busker;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
