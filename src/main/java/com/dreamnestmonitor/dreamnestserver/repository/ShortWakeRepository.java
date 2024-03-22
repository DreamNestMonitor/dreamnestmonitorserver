package com.dreamnestmonitor.dreamnestserver.repository;

import com.dreamnestmonitor.dreamnestserver.model.ShortWake;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ShortWakeRepository extends JpaRepository<ShortWake, Integer> {

    @Query(
            value = "SELECT * FROM ShortWake WHERE swDateTimeFrom BETWEEN ?1 AND ?2",
            nativeQuery = true)
    Optional<List<ShortWake>> findShortWakeUsingDateTimeRangeQuery(LocalDateTime from, LocalDateTime t);
}
