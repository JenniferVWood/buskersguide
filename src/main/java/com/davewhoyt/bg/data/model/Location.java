package com.davewhoyt.bg.data.model;

import javax.persistence.*;

/**
 * The giant blob of annotations that is the SqlResultSetMapping is all in order to get
 * an agregate value in each row returned.  Ultimately this will go away, and become
 * a cached computed value in the table.
 */
@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"latitude", "longitude"}))
@SqlResultSetMapping(
        name = "LocationMapping",
        entities = @EntityResult(
                entityClass = Location.class,
                fields = {
                        @FieldResult(name = "locationId", column = "locationid"),
                        @FieldResult(name = "name", column = "name"),
                        @FieldResult(name = "latitude", column = "latitude"),
                        @FieldResult(name = "longitude", column = "longitude")}),
        columns = @ColumnResult(name="averageRating", type = Double.class))
public class Location {
    @Id
    @GeneratedValue(generator="location_seq")
    @SequenceGenerator(name="location_seq", sequenceName = "location_locationid_seq")
    @Column(name="locationid")
    private Long locationId;

    @Column private String name;
    @Column private Integer latitude;
    @Column private Integer longitude;

    @Transient
    public Double averageRating; // calculated

    @Transient
    private Integer rating; // submitted by user




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


    public Integer getLatitude() {
        return latitude;
    }


    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }


    public Integer getLongitude() {
        return longitude;
    }


    public void setLongitude(Integer longitude) {
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

