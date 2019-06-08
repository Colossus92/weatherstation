package com.devtestguild.weatherstation.Sensor;

import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.persistence.*;

@ApiObject
@Entity
@Table(name="sensor")
public class SensorEntity {

    @ApiObjectField(description = "ID of sensor entity")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ApiObjectField(description = "Type of sensor, like DHT11 for a temperature and humidity sensor")
    private String sensorType;

    @ApiObjectField(description = "Type of data that sensor records, like temperature")
    private String typeOfData;

    @ApiObjectField(description = "Place where sensor is located, like Gouda")
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
