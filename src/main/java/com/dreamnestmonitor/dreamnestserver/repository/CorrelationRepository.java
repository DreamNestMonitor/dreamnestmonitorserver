package com.dreamnestmonitor.dreamnestserver.repository;

import com.dreamnestmonitor.dreamnestserver.model.Correlations;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface CorrelationRepository extends JpaRepository<Correlations, Integer> {

    @Query(
            value = "SELECT * FROM Correlations WHERE sleepStartDate = ?1",
            nativeQuery = true)
    Optional<Correlations> findCorrelationByStartDate(LocalDateTime startDate);
}
