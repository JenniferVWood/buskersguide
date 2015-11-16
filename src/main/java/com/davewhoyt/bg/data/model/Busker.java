package com.davewhoyt.bg.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by david on 11/10/15.
 */
@Entity
public class Busker {
    @Id
    @GeneratedValue
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
