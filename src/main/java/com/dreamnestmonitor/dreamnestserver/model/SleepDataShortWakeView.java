package com.dreamnestmonitor.dreamnestserver.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SleepDataShortWakeView {

    @Id
    @Column(name = "source")
    private String source;

    @Column(name = "sleepID")
    private Integer sleepID;

    @Column(name = "startTime")
    private LocalDateTime startTime;

    @Column(name = "endTime")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private SleepData.LEVELS level;

    public Integer getSleepID() {
        return sleepID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public SleepData.LEVELS getLevel() {
        return level;
    }
}
