package com.dreamnestmonitor.dreamnestserver.controller;

import com.dreamnestmonitor.dreamnestserver.model.ShortWake;
import com.dreamnestmonitor.dreamnestserver.pojo.ShortWakeFitBitPOJO;
import com.dreamnestmonitor.dreamnestserver.repository.ShortWakeRepository;
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
public class ShortWakeController {

    private final ShortWakeRepository repository;

    ShortWakeController (ShortWakeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/shortwake")
    ShortWake newSleepData(@RequestBody ShortWake newShortWake) {
        return repository.save(newShortWake);
    }

    @PostMapping("/shortwake/batch")
    List<ShortWake> newShortWakeBatch(@RequestBody ShortWakeFitBitPOJO[] newShortWakeBatch) {
        List<ShortWake> saved = new ArrayList<>();
        for (ShortWakeFitBitPOJO newShortWake: newShortWakeBatch) {
            // Convert fields to fields used in DreamNest Monitor application
            LocalDate swDateFrom = newShortWake.getDateTime().toLocalDate();
            LocalTime swTimeFrom = newShortWake.getDateTime().toLocalTime();
            LocalDateTime swDateTimeTo = newShortWake.getDateTime().plusSeconds(newShortWake.getSeconds());
            LocalDate swDateTo = swDateTimeTo.toLocalDate();
            LocalTime swTimeTo = swDateTimeTo.toLocalTime();
            saved.add(repository.save(new ShortWake(newShortWake.getDateTime(), swDateFrom, swTimeFrom, swDateTimeTo, swDateTo, swTimeTo, newShortWake.getSeconds())));
        }
        return saved;
    }

    @GetMapping("/shortwake")
    List<ShortWake> getAll() {
        return repository.findAll();
    }

    @GetMapping("/shortwake/range")
    List<ShortWake> getByDateTimeRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to
    ) {
        Optional<List<ShortWake>> maybeShortWakeFromTimeRange =
                repository.findShortWakeUsingDateTimeRangeQuery(from, to);
        if (maybeShortWakeFromTimeRange.isPresent()) {
            return maybeShortWakeFromTimeRange.get();
        }
        return ImmutableList.of();
    }
}
