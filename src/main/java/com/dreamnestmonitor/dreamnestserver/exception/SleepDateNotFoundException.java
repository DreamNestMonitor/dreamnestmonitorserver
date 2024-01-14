package com.dreamnestmonitor.dreamnestserver.exception;

public class SleepDateNotFoundException extends RuntimeException {
    public SleepDateNotFoundException(Long id) {
        super("Coud not find sleep date with id: " + id);
    }
}
