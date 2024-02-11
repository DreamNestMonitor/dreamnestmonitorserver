package com.dreamnestmonitor.dreamnestserver.exception;

public class SleepDataNotFoundException extends RuntimeException {
    public SleepDataNotFoundException(Integer id) {
        super("Coud not find sleep data with id: " + id);
    }
}
