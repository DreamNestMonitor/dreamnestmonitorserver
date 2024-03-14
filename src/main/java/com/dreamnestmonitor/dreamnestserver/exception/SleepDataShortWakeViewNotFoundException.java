package com.dreamnestmonitor.dreamnestserver.exception;

public class SleepDataShortWakeViewNotFoundException extends RuntimeException {
    public SleepDataShortWakeViewNotFoundException(Integer id) {
        super("Coud not find sleep data with id: " + id);
    }
}
