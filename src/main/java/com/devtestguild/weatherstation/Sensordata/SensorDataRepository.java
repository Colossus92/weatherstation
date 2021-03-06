package com.devtestguild.weatherstation.Sensordata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorDataEntity, Integer> {
    List<SensorDataEntity> findBySensorId(int id);

    List<SensorDataEntity> findAllByTimestampBetween(ZonedDateTime from, ZonedDateTime toInclusive);
}
