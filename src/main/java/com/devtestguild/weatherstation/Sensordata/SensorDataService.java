package com.devtestguild.weatherstation.Sensordata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class SensorDataService {

    private SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    List<SensorDataEntity> findAll() {
        return sensorDataRepository.findAll();
    }

    void createNewSensorDataList(List<SensorDataEntity> sensorDataEntityList){
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
