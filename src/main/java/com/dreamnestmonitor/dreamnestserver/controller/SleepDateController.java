package com.dreamnestmonitor.dreamnestserver.controller;

import com.dreamnestmonitor.dreamnestserver.exception.SleepDateNotFoundException;
import com.dreamnestmonitor.dreamnestserver.model.SleepDate;
import com.dreamnestmonitor.dreamnestserver.pojo.SleepDateFitBitPOJO;
import com.dreamnestmonitor.dreamnestserver.repository.SleepDateRepository;
import com.google.common.base.Optional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "https://faded-sun-production.up.railway.app")
public class SleepDateController {

    private final SleepDateRepository repository;

    SleepDateController(SleepDateRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/sleepdate")
    SleepDate newSleepDate(@RequestBody SleepDateFitBitPOJO newSleepDate) {
        LocalDate sleepDateFrom = newSleepDate.getStartTime().toLocalDate();
        LocalTime sleepTimeFrom = newSleepDate.getStartTime().toLocalTime();
        LocalDate sleepDateTo = newSleepDate.getEndTime().toLocalDate();
        LocalTime sleepTimeTo = newSleepDate.getEndTime().toLocalTime();
        return repository.save(new SleepDate(newSleepDate.getStartTime(), sleepDateFrom, sleepTimeFrom, newSleepDate.getEndTime(), sleepDateTo, sleepTimeTo));
    }

    @GetMapping("/sleepdate")
    List<SleepDate> getAll() {
        return repository.findAllQuery();
    }

    @GetMapping("/sleepdate/{sleepDateID}")
    SleepDate getOne(@PathVariable Long sleepDateID) {
        Optional<SleepDate> maybeSleepDate = repository.findByIdQuery(sleepDateID);
        if (maybeSleepDate.isPresent()) {
            return maybeSleepDate.get();
        }
        throw new SleepDateNotFoundException(sleepDateID);
    }
}
