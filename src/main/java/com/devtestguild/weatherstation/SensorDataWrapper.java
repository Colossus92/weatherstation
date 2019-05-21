package com.devtestguild.weatherstation;

import java.util.List;

public class SensorDataWrapper {

    List<SensorDataEntity> sensorDataEntityList;

    public List<SensorDataEntity> getSensorDataEntityList() {
        return sensorDataEntityList;
    }

    public void setSensorDataEntityList(List<SensorDataEntity> sensorDataEntityList) {
        this.sensorDataEntityList = sensorDataEntityList;
    }
}
