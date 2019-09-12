package com.devtestguild.weatherstation;

import com.devtestguild.weatherstation.Sensor.SensorEntity;
import com.devtestguild.weatherstation.Sensor.SensorRepository;
import com.devtestguild.weatherstation.Sensor.SensorService;
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
public class SensorServiceTest {


    @TestConfiguration
    static class SensorServiceTestContextConfiguration {
        @Autowired
        SensorRepository sensorRepository;

        @Bean
        public SensorService sensorService() {
            return new SensorService(sensorRepository);
        }
    }

    @MockBean
    SensorRepository sensorRepository;

    @Autowired
    SensorService sensorService;

    private SensorEntity[] sensorEntities = new SensorEntity[2];

    @Before
    public void setup() {
        sensorEntities[0] = new SensorEntity("DC11", "Temperature", "Rotterdam");
        sensorEntities[1] = new SensorEntity("DC11", "Humidity", "Rotterdam");

        List<SensorEntity> sensorEntityList = new ArrayList<>();
        sensorEntityList.add(sensorEntities[0]);
        sensorEntityList.add(sensorEntities[1]);

        Mockito.when(sensorRepository.save(sensorEntities[0])).thenReturn(sensorEntities[0]);
        Mockito.when(sensorRepository.findAll()).thenReturn(sensorEntityList);
    }

    @Test
    public void findAll() {
        List<SensorEntity> returnedSensorEntities = sensorRepository.findAll();

        assertThat(returnedSensorEntities.size(), equalTo(2));
    }

}
