package com.devtestguild.weatherstation.Sensordata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity findAll() {
        List<SensorDataEntity> sensorDataEntityList = sensorDataRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK)
        .body(sensorDataEntityList);
    }

    public void createNewSensorDataList(List<SensorDataEntity> sensorDataEntityList){
        for(SensorDataEntity sensorDataEntity:sensorDataEntityList){
            sensorDataRepository.save(sensorDataEntity);
        }
    }

    List<SensorDataEntity> deleteById(int id){
        sensorDataRepository.deleteById(id);

        return sensorDataRepository.findAll();
    }

    List<SensorDataEntity> getDataFromSensor(int id){
        return sensorDataRepository.findBySensorId(id);
    }

    List<SensorDataEntity> getDataBetweenDateTime(ZonedDateTime from, ZonedDateTime toInclusive) {
        return sensorDataRepository.findAllByTimestampBetween(from, toInclusive);
    }
}
