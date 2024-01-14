package com.dreamnestmonitor.dreamnestserver.repository;

import com.dreamnestmonitor.dreamnestserver.model.EnvironmentData;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface EnvironmentDataRepository extends JpaRepository<EnvironmentData, Long> {

    @Query(
            value = "SELECT * FROM EnvironmentData WHERE environmentDataID = ?1",
            nativeQuery = true)
    Optional<EnvironmentData> findByIdQuery(Long environmentDataId);

    @Query(
            value = "SELECT * FROM EnvironmentData",
            nativeQuery = true)
    List<EnvironmentData> findAllQuery();

    @Query(
            value = "SELECT * FROM EnvironmentData WHERE envDateTime BETWEEN ?1 AND ?2",
            nativeQuery = true)
    Optional<List<EnvironmentData>> findTemperatureUsingDateTimeRangeQuery(LocalDateTime from, LocalDateTime t);
}
