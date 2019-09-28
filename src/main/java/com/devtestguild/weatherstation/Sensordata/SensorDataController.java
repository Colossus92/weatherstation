package com.devtestguild.weatherstation.Sensordata;

import com.devtestguild.weatherstation.RequestBodies.BetweenDateTime;
import lombok.extern.slf4j.Slf4j;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(name = "Sensordata services", description = "Methods for managing sensordata entries", visibility = ApiVisibility.PUBLIC)
@RestController
@RequestMapping(value = "/sensordata")
@Slf4j
public class SensorDataController {

    private SensorDataService sensorDataService;

    @Autowired
    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @ApiMethod(description = "Get all sensordata entries")
    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<SensorDataEntity> getAllData(){
        return sensorDataService.findAll();
    }

    @ApiMethod(description = "Create new sensordata entries")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<SensorDataEntity> createNewSensorDataEntityList(@RequestBody List<SensorDataEntity> sensorDataEntityList){
        sensorDataService.createNewSensorDataList(sensorDataEntityList);
        return sensorDataService.findAll();
    }

    @ApiMethod(description = "Delete sensordata entry by ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<SensorDataEntity> remove(@ApiPathParam(name = "Sensordata entity ID", description = "ID of data record which has to be deleted") @PathVariable int id){
        return sensorDataService.deleteById(id);
    }

    @ApiMethod(description = "Retrieve data by sensor ID")
    @RequestMapping(value = "/{sensorId}/get-data", method = RequestMethod.GET)
    public List<SensorDataEntity> getDataFromSensor(@ApiPathParam(name="Sensor ID", description = "ID of sensor which recorded desired data") @PathVariable int sensorId){
        return sensorDataService.getDataFromSensor(sensorId);
    }

    @ApiMethod(description = "Retrieve data between timestamp")
    @RequestMapping(value = "/get-between-timestamp")
    public List<SensorDataEntity> getDataBetween(BetweenDateTime betweenDateTimeRequest){
        return sensorDataService.getDataBetweenDateTime(betweenDateTimeRequest.getFrom(), betweenDateTimeRequest.getToInclusive());
    }
}
