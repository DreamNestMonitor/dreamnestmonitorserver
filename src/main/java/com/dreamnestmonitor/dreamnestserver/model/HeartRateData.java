package com.dreamnestmonitor.dreamnestserver.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class HeartRateData {

    @Id
    @Column(name = "rateDateTime")
    private LocalDateTime rateDateTime;

    @Column(name = "rate")
    private Integer rate;

    protected HeartRateData() {}

    public HeartRateData(LocalDateTime rateDateTime, Integer rate) {
        this.rateDateTime = rateDateTime;
        this.rate = rate;
    }

    public LocalDateTime getRateDateTime() {
        return rateDateTime;
    }

    public Integer getRate() {
        return rate;
    }
}
