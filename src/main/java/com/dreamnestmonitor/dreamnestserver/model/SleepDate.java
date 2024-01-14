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

    public LocalDateTime getSleepDateTimeFrom() {
        return sleepDateTimeFrom;
    }

    public void setSleepDateTimeFrom(LocalDateTime sleepDateTimeFrom) {
        this.sleepDateTimeFrom = sleepDateTimeFrom;
    }

    public LocalDate getSleepDateFrom() {
        return sleepDateFrom;
    }

    public void setSleepDateFrom(LocalDate sleepDateFrom) {
        this.sleepDateFrom = sleepDateFrom;
    }

    public LocalTime getSleepTimeFrom() {
        return sleepTimeFrom;
    }

    public void setSleepTimeFrom(LocalTime sleepTimeFrom) {
        this.sleepTimeFrom = sleepTimeFrom;
    }

    public LocalDateTime getSleepDateTimeTo() {
        return sleepDateTimeTo;
    }

    public void setSleepDateTimeTo(LocalDateTime sleepDateTimeTo) {
        this.sleepDateTimeTo = sleepDateTimeTo;
    }

    public LocalDate getSleepDateTo() {
        return sleepDateTo;
    }

    public void setSleepDateTo(LocalDate sleepDateTo) {
        this.sleepDateTo = sleepDateTo;
    }

    public LocalTime getSleepTimeTo() {
        return sleepTimeTo;
    }

    public void setSleepTimeTo(LocalTime sleepTimeTo) {
        this.sleepTimeTo = sleepTimeTo;
    }
}
