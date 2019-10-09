package com.devtestguild.weatherstation.Weatherstation;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.persistence.*;
import java.util.List;

@ApiObject
@Entity
@Table(name="weatherstation")
public class WeatherstationEntity {

    @ApiObjectField(description = "ID of weatherstation")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ApiObjectField(description = "Location of weatherstation")
    private String location;

    @ApiObjectField(description = "List of sensors attached to the weatherstation")
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> sensorEntities;

    public WeatherstationEntity() {
    }

    public WeatherstationEntity(String location, List<Integer> sensorEntities) {
        this.location = location;
        this.sensorEntities = sensorEntities;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public List<Integer> getSensorEntities() {
        return sensorEntities;
    }

    public void setSensorEntities(List<Integer> newSensorEntities) {
        this.sensorEntities = newSensorEntities;
    }
}
