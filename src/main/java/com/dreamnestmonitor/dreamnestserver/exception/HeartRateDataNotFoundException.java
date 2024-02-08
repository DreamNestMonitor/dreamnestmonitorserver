package com.dreamnestmonitor.dreamnestserver.exception;

public class HeartRateDataNotFoundException extends RuntimeException{
    public HeartRateDataNotFoundException() {
        super("Coud not find heart rate data");
    }
}
