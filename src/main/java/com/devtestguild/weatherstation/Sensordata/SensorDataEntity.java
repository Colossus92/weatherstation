package com.devtestguild.weatherstation.Sensordata;

import org.jsondoc.core.annotation.ApiObject;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@ApiObject
@Entity
@Table(name="sensor_data")
public class SensorDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String value;

    @Column(name="data_type")
    private String typeOfData;
    private int sensorId;

    public SensorDataEntity(){
    }

    public SensorDataEntity(int id, String value, String typeOfData, int sensorId) {
        this.id = id;
        this.value = value;
        this.typeOfData = typeOfData;
        this.sensorId = sensorId;
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
}
