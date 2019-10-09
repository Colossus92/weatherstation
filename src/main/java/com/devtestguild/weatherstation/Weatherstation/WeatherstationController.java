package com.devtestguild.weatherstation.Weatherstation;

import lombok.extern.slf4j.Slf4j;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(name = "Weatherstation services", description = "Methods for managing weatherstation entries", visibility = ApiVisibility.PUBLIC)
@RestController
@RequestMapping(value = "/weatherstation")
@Slf4j
public class WeatherstationController {

    private WeatherstationService weatherstationService;

    @Autowired
    public WeatherstationController(WeatherstationService weatherstationService) {
        this.weatherstationService = weatherstationService;
    }

    @ApiMethod(description = "Get all weatherstation entries")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<WeatherstationEntity>> getAllData() {
        return weatherstationService.findAll();
    }

    @ApiMethod(description = "Create weatherstation entry")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createWeatherstation(@RequestBody WeatherstationEntity weatherstationEntity) {
        return weatherstationService.createWeatherstation(weatherstationEntity);
    }

    @ApiMethod(description = "Get weatherstation entry by ID")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<WeatherstationEntity> findById(@ApiPathParam(name = "Weatherstation entity ID", description = "ID of data record which has to be find") @PathVariable int id) {
        return weatherstationService.findById(id);
    }

    @ApiMethod(description = "Add list of SensorEntities to weatherstation")
    @RequestMapping(method = RequestMethod.POST, value = "/{id}/sensors")
    public ResponseEntity<Void> addSensorIds(
            @ApiPathParam(name = "Weatherstation entity ID", description = "ID of data record to which sensor IDs have to be added")
            @PathVariable int id,
            @RequestBody List<Integer> sensorIds) {
        return weatherstationService.addSensorIds(id, sensorIds);
    }

    @ApiMethod(description = "Get list of SensorEntities attached to weatherstation")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}/sensors")
    public ResponseEntity<List<Integer>> getSensorIds(@ApiPathParam(name = "Weatherstation entity ID", description = "ID of data record of which sensor IDs have to be fetched")
                                                      @PathVariable int id) {
        return weatherstationService.getSensorIds(id);
    }

    @ApiMethod(description = "Remove list of SensorEntities attached to weatherstation")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}/sensors")
    public ResponseEntity<List<Integer>> deleteSensorIds(@ApiPathParam(name = "Weatherstation entity ID", description = "ID of data record of which sensor IDs have to be deleted")
                                                         @PathVariable int id,
                                                         @RequestBody List<Integer> sensorIds) {
        return weatherstationService.deleteSensorIds(id, sensorIds);
    }
}
