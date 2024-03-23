package com.dreamnestmonitor.dreamnestserver.controller;

import com.dreamnestmonitor.dreamnestserver.model.EnvironmentData;
import com.dreamnestmonitor.dreamnestserver.model.HeartRateData;
import com.dreamnestmonitor.dreamnestserver.pojo.CurrentHeartRateDatePOJO;
import com.dreamnestmonitor.dreamnestserver.pojo.HeartRateFitBitPOJO;
import com.dreamnestmonitor.dreamnestserver.repository.HeartRateDataRepository;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "https://faded-sun-production.up.railway.app")
public class HeartRateDataController {
    private final HeartRateDataRepository repository;
    private LocalDate currentDate;

    HeartRateDataController(HeartRateDataRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/heartrate/batch")
    List<HeartRateData> newHeartDataBatch(@RequestBody HeartRateFitBitPOJO[] newHeartDataBatch) {
        List<HeartRateData> saved = new ArrayList<>();
        for (HeartRateFitBitPOJO newHeartData : newHeartDataBatch) {
            LocalDateTime rateDateTime = LocalDateTime.of(currentDate, newHeartData.getTime());
            saved.add(repository.save(new HeartRateData(rateDateTime, newHeartData.getValue())));
        }
        return saved;
    }

    @PostMapping("/heartrate/currentdate")
    LocalDate setCurrentHeartRateDate(@RequestBody CurrentHeartRateDatePOJO currentDate) {
        // set the new current heart rate date into an environment variable
        return this.currentDate = currentDate.getDate();
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
