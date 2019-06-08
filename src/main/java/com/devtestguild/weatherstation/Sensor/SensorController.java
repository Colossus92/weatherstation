package com.devtestguild.weatherstation.Sensor;

import lombok.extern.slf4j.Slf4j;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(name = "Sensor services", description = "Methods for managing sensors", visibility = ApiVisibility.PUBLIC)
@RestController
@RequestMapping(value = "/sensor")
@Slf4j
public class SensorController {

    private SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {

        this.sensorService = sensorService;
    }

    @ApiMethod(description = "Retrieve all sensor entities")
    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<SensorEntity> getDataFromSensor(){

        return sensorService.findAll();
    }

    @ApiMethod(description = "Create new sensor entity")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<SensorEntity> createNewSensorEntity(@RequestBody SensorEntity sensorEntity){
        sensorService.createNewSensor(sensorEntity);
        return sensorService.findAll();
    }


}
