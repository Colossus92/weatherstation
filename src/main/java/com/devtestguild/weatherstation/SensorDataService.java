package com.devtestguild.weatherstation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataService {

    private SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public List<SensorDataEntity> findAll() {
        return sensorDataRepository.findAll();
    }

    public void createNewSensorDataList(List<SensorDataEntity> sensorDataEntityList){
        for(SensorDataEntity sensorDataEntity:sensorDataEntityList){
            sensorDataRepository.save(sensorDataEntity);
        }
    }

    public void createNewSensorData(SensorDataEntity sensorDataEntity){
        sensorDataRepository.save(sensorDataEntity);
    }

    public List<SensorDataEntity> deleteById(int id){
        sensorDataRepository.deleteById(id);

        return sensorDataRepository.findAll();
    }

}
