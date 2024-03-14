package com.dreamnestmonitor.dreamnestserver.controller;

import com.dreamnestmonitor.dreamnestserver.model.SleepData;
import com.dreamnestmonitor.dreamnestserver.repository.SleepDataRepository;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
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
    List<SleepData> newSleepDatabatch(@RequestBody SleepData[] newSleepDataBatch) {
        List<SleepData> saved = new ArrayList<>();
        for (SleepData newSleepData : newSleepDataBatch) {
            saved.add(repository.save(newSleepData));
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