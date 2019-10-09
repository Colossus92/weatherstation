package com.devtestguild.weatherstation.Weatherstation;

import com.devtestguild.weatherstation.Sensor.SensorEntity;
import com.devtestguild.weatherstation.Sensordata.SensorDataRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WeatherstationService {

    private WeatherstationRepository weatherstationRepository;

    @Autowired
    public WeatherstationService(WeatherstationRepository weatherstationRepository) {
        this.weatherstationRepository = weatherstationRepository;
    }

    public ResponseEntity<List<WeatherstationEntity>> findAll() {
        return ResponseEntity.ok().body(weatherstationRepository.findAll());
    }

    public ResponseEntity<WeatherstationEntity> findById(int id){
        Optional<WeatherstationEntity> weatherstationEntityOptional = this.weatherstationRepository.findById(id);

        if(weatherstationEntityOptional.isPresent()) {
            return ResponseEntity.ok().body(weatherstationEntityOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> createWeatherstation(WeatherstationEntity weatherstationEntity) {
        this.weatherstationRepository.save(weatherstationEntity);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> addSensorIds(int id, List<Integer> newSensorIds) {
        Optional<WeatherstationEntity> weatherstationEntityOptional = this.weatherstationRepository.findById(id);

        if(weatherstationEntityOptional.isPresent()){
            WeatherstationEntity weatherstation = weatherstationEntityOptional.get();
            List<Integer> sensorEntities = weatherstation.getSensorEntities();

            if(sensorEntities.isEmpty()){
                weatherstation.setSensorEntities(newSensorIds);
                weatherstationRepository.save(weatherstation);
            }else{
                newSensorIds = newSensorIds.stream()
                        .filter(sensorId -> !sensorEntities.contains(sensorId))
                        .collect(Collectors.toList());

                sensorEntities.addAll(newSensorIds);

                weatherstation.setSensorEntities(sensorEntities);
                weatherstationRepository.save(weatherstation);
            }
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<Integer>> getSensorIds(int id) {
        Optional<WeatherstationEntity> weatherstationEntityOptional = this.weatherstationRepository.findById(id);

        if(weatherstationEntityOptional.isPresent()){
            WeatherstationEntity weatherstation = weatherstationEntityOptional.get();

            return ResponseEntity.ok().body(weatherstation.getSensorEntities());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<Integer>> deleteSensorIds(int id, List<Integer> deleteSensorIds) {
        Optional<WeatherstationEntity> weatherstationEntityOptional = this.weatherstationRepository.findById(id);

        if(weatherstationEntityOptional.isPresent()){
            WeatherstationEntity weatherstation = weatherstationEntityOptional.get();
            List<Integer> sensorIds = weatherstation.getSensorEntities();

            deleteSensorIds.stream()
                    .filter(sensorIds::contains)
                    .forEach(sensorIds::remove);

            weatherstation.setSensorEntities(sensorIds);
            weatherstationRepository.save(weatherstation);

            return ResponseEntity.ok().body(weatherstation.getSensorEntities());
        }else {

            return ResponseEntity.notFound().build();
        }
    }
}
