package com.dreamnestmonitor.dreamnestserver.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class EnvironmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "environmentDataID")
    private Integer environmentDataID;

    @Column(name = "envDateTime")
    private LocalDateTime envDateTime;

    @Column(name = "envDate")
    private LocalDate envDate;

    @Column(name = "envTime")
    private LocalTime envTime;

    @Column(name = "temp")
    private Float temp;

    @Column(name = "brightness")
    private Float brightness;

    @Column(name = "noise")
    private Float noise;

    protected EnvironmentData() {}

    public EnvironmentData(LocalDateTime envDateTime, LocalDate envDate, LocalTime envTime, Float temp,
                           Float brightness, Float noise) {
        this.envDateTime = envDateTime;
        this.envDate = envDate;
        this.envTime = envTime;
        this.temp = temp;
        this.brightness = brightness;
        this.noise = noise;
    }

    public Integer getEnvironmentDataID() {
        return environmentDataID;
    }

    public LocalDateTime getEnvDateTime() {
        return envDateTime;
    }

    public LocalDate getEnvDate() {
        return envDate;
    }

    public LocalTime getEnvTime() {
        return envTime;
    }

    public Float getTemp() {
        return temp;
    }

    public Float getBrightness() {
        return brightness;
    }

    public Float getNoise() {
        return noise;
    }
}
