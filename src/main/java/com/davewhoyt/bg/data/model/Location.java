package com.davewhoyt.bg.data.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The giant blob of annotations that is the SqlResultSetMapping is all in order to get
 * an aggregate value in each row returned.  Ultimately this will go away, and become
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
                        @FieldResult(name = "longitude", column = "longitude")
                }),
        columns = {@ColumnResult(name="averageRating", type = Double.class)
        , @ColumnResult(name="distanceInMeters", type = Double.class)})
public class Location {
    @Id
    @GeneratedValue(generator="location_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="location_seq", sequenceName = "location_locationid_seq")
    @Column(name="locationid")
    private Long locationId;

    @Column private String name;
    @Column private Double latitude;
    @Column private Double longitude;

    /** calculated by some queries*/
    @Transient
    private Double averageRating;

    /** calculated by some queries*/
    @Transient private Double distanceInMeters;


    /** included in this model because a controller(!) uses this type to record a location+rating */
    // TODO: violates separation of concerns
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

    public Double getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(Double distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }
}

