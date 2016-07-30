package com.davewhoyt.bg.data.model;

import javax.persistence.*;

/**
 * Created by david on 11/10/15.
 */
@Entity
public class Busker {
    @Id
    @GeneratedValue(generator="busker_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="busker_seq", sequenceName = "busker_buskerid_seq")
    @Column(name="ratingid")
    private Long buskerId;

    @Column
    private String name;

    public Long getBuskerId() {
        return buskerId;
    }

    public void setBuskerId(Long buskerId) {
        this.buskerId = buskerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
