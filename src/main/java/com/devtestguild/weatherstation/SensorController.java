package com.devtestguild.weatherstation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sensor")
@Slf4j
public class SensorController {

    private SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {

        this.sensorService = sensorService;
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<SensorEntity> getDataFromSensor(){

        return sensorService.findAll();
    }

    @RequestMapping(value = "/{sensorId}/get-data", method = RequestMethod.GET)
    public List<SensorDataEntity> getDataFromSensor(@PathVariable int sensorId){
        List<SensorDataEntity> dataList = sensorService.getDataFromSensor(sensorId);

        return dataList;
    }
}
