package com.dreamnestmonitor.dreamnestserver.repository;

import com.dreamnestmonitor.dreamnestserver.model.SleepDate;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SleepDateRepository extends JpaRepository<SleepDate, Long> {

    @Query(
            value = "SELECT * FROM SleepDate WHERE environmentDataID = ?1",
            nativeQuery = true)
    Optional<SleepDate> findByIdQuery(Long environmentDataId);

    @Query(
            value = "SELECT * FROM SleepDate",
            nativeQuery = true)
    List<SleepDate> findAllQuery();
}
