package com.dreamnestmonitor.dreamnestserver.controller;

import com.dreamnestmonitor.dreamnestserver.model.EnvironmentData;
import com.dreamnestmonitor.dreamnestserver.model.HeartRateData;
import com.dreamnestmonitor.dreamnestserver.repository.HeartRateDataRepository;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://faded-sun-production.up.railway.app")
public class HeartRateDataController {
    private final HeartRateDataRepository repository;

    HeartRateDataController(HeartRateDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/heartrate/range")
    List<HeartRateData> getByDateTimeRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to
    ) {
        Optional<List<HeartRateData>> maybeHeartRateDataFromDateTimeRange =
                repository.findHeartBeatUsingDateTimeRangeQuery(from, to);
        if (maybeHeartRateDataFromDateTimeRange.isPresent()) {
            return maybeHeartRateDataFromDateTimeRange.get();
        }
        return ImmutableList.of();
    }
}
