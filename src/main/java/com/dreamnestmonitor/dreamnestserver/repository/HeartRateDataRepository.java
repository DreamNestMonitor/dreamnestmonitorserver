package com.dreamnestmonitor.dreamnestserver.repository;

import com.dreamnestmonitor.dreamnestserver.model.HeartRateData;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface HeartRateDataRepository extends JpaRepository<HeartRateData, Long> {
    @Query(
            value = "SELECT * FROM HeartRateData WHERE rateDateTime BETWEEN ?1 AND ?2",
            nativeQuery = true)
    Optional<List<HeartRateData>> findHeartBeatUsingDateTimeRangeQuery(LocalDateTime from, LocalDateTime t);
}
