package com.davewhoyt.bg.data.model;

import javax.persistence.*;

/**
 * Created by david on 11/10/15.
 *
 * What I really want this to be is:
 *
 * select
 location.locationid
 , location.name
 , location.latitude
 , location.longitude
 , avg(rating.value)

 from location
 inner join rating on location.locationid = rating.locationid

 group by location.locationid
 ;
 */
@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"latitude", "longitude"}))
public class ReadWriteLocation {
    @Id
    @GeneratedValue(generator="location_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="location_seq", sequenceName = "location_locationid_seq")
    @Column(name="locationid")
    private Long locationId;

    @Column private String name;
    @Column private Double latitude;
    @Column private Double longitude;



    private Double averageRating; // want this to be avg

    @Transient
    private Integer rating;

    
    public Long getLocationId() {
        return locationId;
    }

    
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public Double getLatitude() {
        return latitude;
    }

    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    
    public Double getLongitude() {
        return longitude;
    }

    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    
    public Integer getRating() {
        return rating;
    }

    
    public Double getAverageRating() {
        return averageRating;
    }

    
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
