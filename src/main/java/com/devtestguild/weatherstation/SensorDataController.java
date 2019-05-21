package com.devtestguild.weatherstation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sensordata")
@Slf4j
public class SensorDataController {

    private SensorDataService sensorDataService;

    @Autowired
    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<SensorDataEntity> getAllData(){
        return sensorDataService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<SensorDataEntity> createNewSensorDataEntityList(@RequestBody List<SensorDataEntity> sensorDataEntityList){
        sensorDataService.createNewSensorDataList(sensorDataEntityList);
        return sensorDataService.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<SensorDataEntity> remove(@PathVariable int id){
        return sensorDataService.deleteById(id);
    }

}
