package com.devtestguild.weatherstation.Sensordata;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@ApiObject
@Entity
@Table(name="sensor_data")
public class SensorDataEntity {

    @ApiObjectField(description = "ID of sensordata entity")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ApiObjectField(description = "Recorded value of sensordata")
    private String value;

    @ApiObjectField(description = "Type of datarecord, e.g. temperature")
    @Column(name="data_type")
    private String typeOfData;

    @ApiObjectField(description = "ID of sensor made record")
    private int sensorId;

    @ApiObjectField(description = "Date and time of data record")
    private ZonedDateTime timestamp;

    public SensorDataEntity(){
    }

    public SensorDataEntity(int id, String value, String typeOfData, int sensorId, ZonedDateTime timeStamp) {
        this.id = id;
        this.value = value;
        this.typeOfData = typeOfData;
        this.sensorId = sensorId;
        this.timestamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getTypeOfData() {
        return typeOfData;
    }

    public int getSensorId() {
        return sensorId;
    }

    public ZonedDateTime getTimestamp(){
        return timestamp;
    }
}
