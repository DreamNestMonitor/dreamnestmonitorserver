package com.dreamnestmonitor.dreamnestserver.controller;

import com.dreamnestmonitor.dreamnestserver.exception.EnvironmentDataNotFoundException;
import com.dreamnestmonitor.dreamnestserver.model.EnvironmentData;
import com.dreamnestmonitor.dreamnestserver.repository.EnvironmentDataRepository;
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
public class EnvironmentDataController {

    private final EnvironmentDataRepository repository;

    EnvironmentDataController(EnvironmentDataRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/environmentdata")
    EnvironmentData newEnvironmentData(@RequestBody EnvironmentData newEnvironmentData) {
        return repository.save(newEnvironmentData);
    }

    @PostMapping("/environmentdata/batch")
    List<EnvironmentData> newEnvironmentDataBatch(@RequestBody EnvironmentData[] newEnvironmentDataBatch) {
        List<EnvironmentData> saved = new ArrayList<>();
        for (EnvironmentData newEnvironmentData : newEnvironmentDataBatch) {
            saved.add(repository.save(newEnvironmentData));
        }
        return saved;
    }

    @GetMapping("/environmentdata")
    List<EnvironmentData> getAll() {
        return repository.findAllQuery();
    }

    @GetMapping("/environmentdata/{environmentDataId}")
    EnvironmentData getOne(@PathVariable Long environmentDataId) {
        Optional<EnvironmentData> maybeEnvironmentData = repository.findByIdQuery(environmentDataId);
        if (maybeEnvironmentData.isPresent()) {
            return maybeEnvironmentData.get();
        }
        throw new EnvironmentDataNotFoundException();
    }

    @GetMapping("/environmentdata/range")
    List<EnvironmentData> getByDateTimeRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to
            ) {
        Optional<List<EnvironmentData>> maybeEnvironmentDataFromDateTimeRange =
                repository.findTemperatureUsingDateTimeRangeQuery(from, to);
        if (maybeEnvironmentDataFromDateTimeRange.isPresent()) {
            return maybeEnvironmentDataFromDateTimeRange.get();
        }
        return ImmutableList.of();
    }
}
