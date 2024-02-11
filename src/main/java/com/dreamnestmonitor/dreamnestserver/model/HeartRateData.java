package com.dreamnestmonitor.dreamnestserver.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class HeartRateData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rateID")
    private Integer rateID;

    @Column(name = "rateDateTime")
    private LocalDateTime rateDateTime;

    @Column(name = "rateDate")
    private LocalDate rateDate;

    @Column(name = "rateTime")
    private LocalTime rateTime;

    @Column(name = "rate")
    private Integer rate;

    protected HeartRateData() {}

    public HeartRateData(LocalDateTime rateDateTime, LocalDate rateDate, LocalTime rateTime, Integer rate) {
        this.rateDateTime = rateDateTime;
        this.rateDate = rateDate;
        this.rateTime = rateTime;
        this.rate = rate;
    }

    public Integer getRateID() {
        return rateID;
    }

    public LocalDateTime getRateDateTime() {
        return rateDateTime;
    }

    public LocalDate getRateDate() {
        return rateDate;
    }

    public LocalTime getRateTime() {
        return rateTime;
    }

    public Integer getRate() {
        return rate;
    }
}
