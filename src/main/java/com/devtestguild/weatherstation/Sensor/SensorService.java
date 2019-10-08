package com.devtestguild.weatherstation.Sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.List;

@Service
public class SensorService {

    private SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    ResponseEntity<List<SensorEntity>> findAll() {
        return ResponseEntity.ok().body(sensorRepository.findAll());
    }

    ResponseEntity<Void> createNewSensor(SensorEntity sensorEntity) {
        sensorRepository.save(sensorEntity);

        return ResponseEntity.noContent().build();
    }
}
