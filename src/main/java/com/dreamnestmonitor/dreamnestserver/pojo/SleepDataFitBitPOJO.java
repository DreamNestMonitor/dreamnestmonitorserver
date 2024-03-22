package com.dreamnestmonitor.dreamnestserver.pojo;

import com.dreamnestmonitor.dreamnestserver.model.SleepData;

import java.time.LocalDateTime;

public class SleepDataFitBitPOJO {
    private LocalDateTime dateTime;
    private SleepData.LEVELS level;
    private Integer seconds;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public SleepData.LEVELS getLevel() {
        return level;
    }

    public Integer getSeconds() {
        return seconds;
    }
}
