package com.dreamnestmonitor.dreamnestserver.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class SleepData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sleepDataID")
    private Integer sleepDataID;

    @Column(name = "sdDateTimeFrom")
    private LocalDateTime sdDateTimeFrom;

    @Column(name = "sdDateFrom")
    private LocalDate sdDateFrom;

    @Column(name = "sdTimeFrom")
    private LocalTime sdTimeFrom;

    @Column(name = "sdDateTimeTo")
    private LocalDateTime sdDateTimeTo;

    @Column(name = "sdDateTo")
    private LocalDate sdDateTo;

    @Column(name = "sdTimeTo")
    private LocalTime sdTimeTo;

    @Column(name = "seconds")
    private Integer seconds;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private LEVELS level;

    public LocalDateTime getSdDateTimeFrom() {
        return sdDateTimeFrom;
    }

    public LocalDate getSdDateFrom() {
        return sdDateFrom;
    }

    public LocalTime getSdTimeFrom() {
        return sdTimeFrom;
    }

    public LocalDateTime getSdDateTimeTo() {
        return sdDateTimeTo;
    }

    public LocalDate getSdDateTo() {
        return sdDateTo;
    }

    public LocalTime getSdTimeTo() {
        return sdTimeTo;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public LEVELS getLevel() {
        return level;
    }

    public enum LEVELS {
        wake,
        light,
        deep,
        rem
    }
}
