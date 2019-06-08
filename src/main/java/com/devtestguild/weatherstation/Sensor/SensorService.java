package com.devtestguild.weatherstation.Sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    List<SensorEntity> findAll() {
        return sensorRepository.findAll();
    }

    void createNewSensor(SensorEntity sensorEntity) {
        sensorRepository.save(sensorEntity);
    }
}
