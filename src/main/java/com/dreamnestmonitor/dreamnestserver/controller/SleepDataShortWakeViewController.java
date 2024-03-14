package com.dreamnestmonitor.dreamnestserver.controller;

import com.dreamnestmonitor.dreamnestserver.model.SleepDataShortWakeView;
import com.dreamnestmonitor.dreamnestserver.repository.SleepDataShortWakeViewRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class SleepDataShortWakeViewController {

    private final SleepDataShortWakeViewRepository repository;

    SleepDataShortWakeViewController(SleepDataShortWakeViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/view")
    List<SleepDataShortWakeView> getAll() {
        return repository.findAllQuery();
    }
}
