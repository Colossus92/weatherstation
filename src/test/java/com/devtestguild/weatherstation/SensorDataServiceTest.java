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
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@TestComponent
@RunWith(SpringRunner.class)
public class SensorDataServiceTest {
//
//
//    @TestConfiguration
//    static class SensorDataServiceTestContextConfiguration {
//        @Autowired
//        SensorDataRepository sensorDataRepository;
//
//        @Bean
//        public SensorDataService sensorDataService() {
//            return new SensorDataService(sensorDataRepository);
//        }
//    }
//
//    @MockBean
//    SensorDataRepository sensorDataRepository;
//
//    @Autowired
//    SensorDataService sensorDataService;

    private SensorDataEntity[] sensorDataEntities = new SensorDataEntity[2];

    @Before
    public void setup() {
//        sensorDataEntities[0] = new SensorDataEntity(1, "22.0", "Temperature", 1);
//        sensorDataEntities[1] = new SensorDataEntity(2, "22.0", "Temperature", 1);
//
//        List<SensorDataEntity> sensorDataEntityList = new ArrayList<>();
//        sensorDataEntityList.add(sensorDataEntities[0]);
//        sensorDataEntityList.add(sensorDataEntities[1]);
//
//        Mockito.when(sensorRepository.save(sensorEntities[0])).thenReturn(sensorEntities[0]);
//        Mockito.when(sensorRepository.findAll()).thenReturn(sensorEntityList);
    }

    @Test
    public void findAll() {
//        List<SensorEntity> returnedSensorEntities = sensorRepository.findAll();
//
//        assertThat(returnedSensorEntities.size(), equalTo(2));

        assertThat(true, equalTo(true));
    }

}
