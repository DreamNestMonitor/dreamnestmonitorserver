package com.dreamnestmonitor.dreamnestserver.repository;

import com.dreamnestmonitor.dreamnestserver.model.SleepData;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SleepDataRepository extends JpaRepository<SleepData, Integer> {
    @Query(
            value = "SELECT * FROM SleepData WHERE sdDateTimeFrom BETWEEN ?1 AND ?2",
            nativeQuery = true)
    Optional<List<SleepData>> findSleepDataUsingDateTimeRangeQuery(LocalDateTime from, LocalDateTime t);
}
