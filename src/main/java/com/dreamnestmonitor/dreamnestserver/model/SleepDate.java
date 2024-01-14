package com.dreamnestmonitor.dreamnestserver.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class SleepDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sleepDateID")
    private Long sleepDateID;

    @Column(name = "sleepDateTimeFrom")
    private LocalDateTime sleepDateTimeFrom;

    @Column(name = "sleepDateFrom")
    private LocalDate sleepDateFrom;

    @Column(name = "sleepTimeFrom")
    private LocalTime sleepTimeFrom;

    @Column(name = "sleepDateTimeTo")
    private LocalDateTime sleepDateTimeTo;

    @Column(name = "sleepDateTo")
    private LocalDate sleepDateTo;

    @Column(name = "sleepTimeTo")
    private LocalTime sleepTimeTo;

    protected SleepDate() {}

    public SleepDate(LocalDateTime sleepDateTimeFrom, LocalDate sleepDateFrom, LocalTime sleepTimeFrom,
                     LocalDateTime sleepDateTimeTo, LocalDate sleepDateTo, LocalTime sleepTimeTo) {
        this.sleepDateTimeFrom = sleepDateTimeFrom;
        this.sleepDateFrom = sleepDateFrom;
        this.sleepTimeFrom = sleepTimeFrom;
        this.sleepDateTimeTo = sleepDateTimeTo;
        this.sleepDateTo = sleepDateTo;
        this.sleepTimeTo = sleepTimeTo;
    }

    public Long getSleepDateID() {
        return sleepDateID;
    }

    public LocalDateTime getSleepDateTimeFrom() {
        return sleepDateTimeFrom;
    }

    public LocalDate getSleepDateFrom() {
        return sleepDateFrom;
    }

    public LocalTime getSleepTimeFrom() {
        return sleepTimeFrom;
    }

    public LocalDateTime getSleepDateTimeTo() {
        return sleepDateTimeTo;
    }

    public LocalDate getSleepDateTo() {
        return sleepDateTo;
    }

    public LocalTime getSleepTimeTo() {
        return sleepTimeTo;
    }
}
