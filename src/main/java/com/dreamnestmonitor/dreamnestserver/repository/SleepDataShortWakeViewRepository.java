package com.dreamnestmonitor.dreamnestserver.repository;

import com.dreamnestmonitor.dreamnestserver.model.SleepDataShortWakeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SleepDataShortWakeViewRepository extends JpaRepository<SleepDataShortWakeView, Integer> {
    @Query(
            value = "SELECT * FROM sleepdatashortwakeview",
            nativeQuery = true)
    List<SleepDataShortWakeView> findAllQuery();
}
