package com.devtestguild.weatherstation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private SensorRepository sensorRepository;
    private SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository, SensorDataRepository sensorDataRepository) {
        this.sensorRepository = sensorRepository;
        this.sensorDataRepository = sensorDataRepository;
    }

    public List<SensorDataEntity> getDataFromSensor(int id){
        List<SensorDataEntity> sensorDataEntityList = sensorDataRepository.findBySensorId(id);

        return sensorDataEntityList;
    }

    public List<SensorEntity> findAll() {
        return sensorRepository.findAll();
    }
}
