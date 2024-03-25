package com.dreamnestmonitor.dreamnestserver.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Correlations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "correlationID")
    private Integer correlationID;

    @Column(name = "sleepStartDate")
    private LocalDateTime sleepStartDate;

    @Column(name = "temperatureCor")
    private Float temperatureCor;

    @Column(name = "brightnessCor")
    private Float brightnessCor;

    @Column(name = "noiseCor")
    private Float noiseCor;

    public Correlations() {}

    public Correlations(LocalDateTime sleepStartDate, Float temperatureCor, Float brightnessCor, Float noiseCor) {
        this.sleepStartDate = sleepStartDate;
        this.temperatureCor = temperatureCor;
        this.brightnessCor = brightnessCor;
        this.noiseCor = noiseCor;
    }

    public Integer getCorrelationID() {
        return correlationID;
    }

    public LocalDateTime getSleepStartDate() {
        return sleepStartDate;
    }

    public Float getTemperatureCor() {
        return temperatureCor;
    }

    public Float getBrightnessCor() {
        return brightnessCor;
    }

    public Float getNoiseCor() {
        return noiseCor;
    }
}
