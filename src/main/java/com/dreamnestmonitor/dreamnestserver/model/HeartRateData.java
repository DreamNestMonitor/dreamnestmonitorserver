package com.dreamnestmonitor.dreamnestserver.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class HeartRateData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rateID")
    private Integer rateID;

    @Column(name = "rateDateTime")
    private LocalDateTime rateDateTime;

    @Column(name = "rate")
    private Integer rate;

    protected HeartRateData() {}

    public HeartRateData(LocalDateTime rateDateTime, Integer rate) {
        this.rateDateTime = rateDateTime;
        this.rate = rate;
    }

    public Integer getRateID() {
        return rateID;
    }

    public LocalDateTime getRateDateTime() {
        return rateDateTime;
    }

    public Integer getRate() {
        return rate;
    }
}
