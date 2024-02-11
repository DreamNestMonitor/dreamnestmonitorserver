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

    @Column(name = "sdDateTime")
    private LocalDateTime sdDateTime;

    @Column(name = "sdDate")
    private LocalDate sdDate;

    @Column(name = "sdTime")
    private LocalTime sdTime;

    @Column(name = "seconds")
    private Integer seconds;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private LEVELS level;

    public LocalDateTime getSdDateTime() {
        return sdDateTime;
    }

    public LocalDate getSdDate() {
        return sdDate;
    }

    public LocalTime getSdTime() {
        return sdTime;
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
