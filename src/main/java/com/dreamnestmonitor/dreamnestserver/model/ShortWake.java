package com.dreamnestmonitor.dreamnestserver.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class ShortWake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shortWakeID")
    private Integer shortWakeID;

    @Column(name = "swDateTimeFrom")
    private LocalDateTime swDateTimeFrom;

    @Column(name = "swDateFrom")
    private LocalDate swDateFrom;

    @Column(name = "swTimeFrom")
    private LocalTime swTimeFrom;

    @Column(name = "swDateTimeTo")
    private LocalDateTime swDateTimeTo;

    @Column(name = "swDateTo")
    private LocalDate swDateTo;

    @Column(name = "swTimeTo")
    private LocalTime swTimeTo;

    @Column(name = "seconds")
    private Integer seconds;

    // default constructor for GET
    public ShortWake() {}

    public ShortWake(LocalDateTime swDateTimeFrom, LocalDate swDateFrom, LocalTime swTimeFrom, LocalDateTime swDateTimeTo, LocalDate swDateTo, LocalTime swTimeTo, Integer seconds) {
        this.swDateTimeFrom = swDateTimeFrom;
        this.swDateFrom = swDateFrom;
        this.swTimeFrom = swTimeFrom;
        this.swDateTimeTo = swDateTimeTo;
        this.swDateTo = swDateTo;
        this.swTimeTo = swTimeTo;
        this.seconds = seconds;
    }

    public Integer getShortWakeID() {
        return shortWakeID;
    }

    public LocalDateTime getSwDateTimeFrom() {
        return swDateTimeFrom;
    }

    public LocalDate getSwDateFrom() {
        return swDateFrom;
    }

    public LocalTime getSwTimeFrom() {
        return swTimeFrom;
    }

    public LocalDateTime getSwDateTimeTo() {
        return swDateTimeTo;
    }

    public LocalDate getSwDateTo() {
        return swDateTo;
    }

    public LocalTime getSwTimeTo() {
        return swTimeTo;
    }

    public Integer getSeconds() {
        return seconds;
    }
}
