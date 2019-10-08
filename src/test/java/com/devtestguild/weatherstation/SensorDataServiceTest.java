package com.devtestguild.weatherstation;

import com.devtestguild.weatherstation.Sensor.SensorEntity;
import com.devtestguild.weatherstation.Sensor.SensorRepository;
import com.devtestguild.weatherstation.Sensor.SensorService;
import com.devtestguild.weatherstation.Sensordata.SensorDataEntity;
import com.devtestguild.weatherstation.Sensordata.SensorDataRepository;
import com.devtestguild.weatherstation.Sensordata.SensorDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@TestComponent
@RunWith(SpringRunner.class)
public class SensorDataServiceTest {


    @TestConfiguration
    static class SensorDataServiceTestContextConfiguration {
        @Autowired
        SensorDataRepository sensorDataRepository;

        @Bean
        public SensorDataService sensorDataService() {
            return new SensorDataService(sensorDataRepository);
        }
    }

    @MockBean
    SensorDataRepository sensorDataRepository;

    @Autowired
    SensorDataService sensorDataService;

    private List<SensorDataEntity> sensorDataEntityList;

    @Before
    public void setup() {
        ZonedDateTime now = ZonedDateTime.now();
        sensorDataEntityList = new ArrayList<>();

        for(int i=0;i<5;i++){
            sensorDataEntityList.add(new SensorDataEntity(i, "18.0", "Temperature", 1, now.plusMinutes(i)));
        }

        Mockito.when(sensorDataRepository.save(sensorDataEntityList.get(0))).thenReturn(sensorDataEntityList.get(0));
        Mockito.when(sensorDataRepository.findAll()).thenReturn(sensorDataEntityList);
    }

    @Test
    public void findAll() {
        ResponseEntity responseEntity = sensorDataService.findAll();
//        List<SensorDataEntity> returnedSensorDataEntities = sensorDataService.findAll();

//        assertThat(returnedSensorDataEntities.size(), equalTo(5));
    }

    @Test
    public void createNewSensorDataList(){
        List<SensorDataEntity> sensorDataEntityList = new ArrayList<>();
        sensorDataEntityList.add(this.sensorDataEntityList.get(0));
        sensorDataService.createNewSensorDataList(sensorDataEntityList);

        List<SensorDataEntity> savedSensorDataEntities = sensorDataRepository.findAll();
        assertThat(savedSensorDataEntities.size(), equalTo(5));
    }

}
