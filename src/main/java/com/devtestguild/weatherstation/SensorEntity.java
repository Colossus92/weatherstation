package com.devtestguild.weatherstation;

import javax.persistence.*;

@Entity
@Table(name="sensor")
public class SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String sensorType;
    private String typeOfData;
    private String location;

    public SensorEntity() {
    }

    public SensorEntity(String sensorType, String typeOfData, String location) {
        this.sensorType = sensorType;
        this.typeOfData = typeOfData;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getTypeOfData() {
        return typeOfData;
    }

    public String getLocation() {
        return location;
    }

    public String getSensorType() {
        return sensorType;
    }
}
