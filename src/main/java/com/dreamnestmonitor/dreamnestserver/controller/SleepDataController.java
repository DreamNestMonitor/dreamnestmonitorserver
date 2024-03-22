package com.dreamnestmonitor.dreamnestserver.controller;

import com.dreamnestmonitor.dreamnestserver.model.SleepData;
import com.dreamnestmonitor.dreamnestserver.pojo.SleepDataFitBitPOJO;
import com.dreamnestmonitor.dreamnestserver.repository.SleepDataRepository;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "https://faded-sun-production.up.railway.app")
public class SleepDataController {

    private final SleepDataRepository repository;

    SleepDataController (SleepDataRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/sleepdata")
    SleepData newSleepData(@RequestBody SleepData newSleepData) {
        return repository.save(newSleepData);
    }

    @PostMapping("/sleepdata/batch")
    List<SleepData> newSleepDatabatch(@RequestBody SleepDataFitBitPOJO[] newSleepDataBatch) {
        List<SleepData> saved = new ArrayList<>();
        for (SleepDataFitBitPOJO newSleepData : newSleepDataBatch) {
            // convert like we did in short wake
            LocalDate sdDateFrom = newSleepData.getDateTime().toLocalDate();
            LocalTime sdTimeFrom = newSleepData.getDateTime().toLocalTime();
            LocalDateTime sdDateTimeTo = newSleepData.getDateTime().plusSeconds(newSleepData.getSeconds());
            LocalDate sdDateTo = sdDateTimeTo.toLocalDate();
            LocalTime sdTimeTo = sdDateTimeTo.toLocalTime();
            saved.add(repository.save(new SleepData(newSleepData.getDateTime(), sdDateFrom, sdTimeFrom, sdDateTimeTo, sdDateTo, sdTimeTo, newSleepData.getSeconds(), newSleepData.getLevel())));
        }
        return saved;
    }

    @GetMapping("/sleepdata")
    List<SleepData> getAll() {
        return repository.findAll();
    }

    @GetMapping("/sleepdata/range")
    List<SleepData> getByDateTimeRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to
    ) {
        Optional<List<SleepData>> maybeSleepDataFromTimeRange =
                repository.findSleepDataUsingDateTimeRangeQuery(from, to);
        if (maybeSleepDataFromTimeRange.isPresent()) {
            return maybeSleepDataFromTimeRange.get();
        }
        return ImmutableList.of();
    }
}