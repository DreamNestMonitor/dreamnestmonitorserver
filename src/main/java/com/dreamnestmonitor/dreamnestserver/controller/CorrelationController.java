package com.dreamnestmonitor.dreamnestserver.controller;


import com.dreamnestmonitor.dreamnestserver.model.Correlations;
import com.dreamnestmonitor.dreamnestserver.repository.CorrelationRepository;
import com.google.common.base.Optional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "https://faded-sun-production.up.railway.app")
public class CorrelationController {


    private final CorrelationRepository repository;

    CorrelationController(CorrelationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/correlations")
    Correlations newCorrelation(@RequestBody Correlations newCorrelation) {
        return repository.save(newCorrelation);
    }

    @GetMapping("/correlations")
    Correlations getByDateTimeRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate
    ) {
        Optional<Correlations> maybeCorrelation =
                repository.findCorrelationByStartDate(startDate);
        if (maybeCorrelation.isPresent()) {
            return maybeCorrelation.get();
        }
        return null;
    }
}
