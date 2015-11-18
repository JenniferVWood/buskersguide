package com.davewhoyt.bg.data.model;

//import org.hibernate.annotations.Type;
//import org.postgis.Point;

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
//                        , @FieldResult(name = "geog", column = "geog")
                }),
        columns = @ColumnResult(name="averageRating", type = Double.class))
public class Location {
    @Id
    @GeneratedValue(generator="location_seq")
    @SequenceGenerator(name="location_seq", sequenceName = "location_locationid_seq")
    @Column(name="locationid")
    private Long locationId;

    @Column private String name;
    @Column private BigDecimal latitude;
    @Column private BigDecimal longitude;

//    @Column
//    @Type(type="org.hibernate.spatial.GeometryType")
//    private Point geog;

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


    public BigDecimal getLatitude() {
        return latitude;
    }


    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }


    public BigDecimal getLongitude() {
        return longitude;
    }


    public void setLongitude(BigDecimal longitude) {
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

//    public Point getGeog() {
//        return geog;
//    }
//
//    public void setGeog(Point geog) {
//        this.geog = geog;
//    }
}

