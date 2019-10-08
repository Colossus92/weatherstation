package com.devtestguild.weatherstation.Sensordata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class SensorDataService {

    private SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public ResponseEntity<List<SensorDataEntity>> findAll() {
        List<SensorDataEntity> sensorDataEntityList = sensorDataRepository.findAll();
        return ResponseEntity.ok().body(sensorDataEntityList);
    }

    public ResponseEntity<Void> createNewSensorDataList(List<SensorDataEntity> sensorDataEntityList){
        for(SensorDataEntity sensorDataEntity:sensorDataEntityList){
            sensorDataRepository.save(sensorDataEntity);
        }

        return ResponseEntity.noContent().build();
    }

    ResponseEntity<Void> deleteById(int id){
        sensorDataRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    ResponseEntity<List<SensorDataEntity>> getDataFromSensor(int id){
        return ResponseEntity.ok().body(sensorDataRepository.findBySensorId(id));
    }

    ResponseEntity<List<SensorDataEntity>> getDataBetweenDateTime(ZonedDateTime from, ZonedDateTime toInclusive) {
        return ResponseEntity.ok().body(sensorDataRepository.findAllByTimestampBetween(from, toInclusive));
    }
}
