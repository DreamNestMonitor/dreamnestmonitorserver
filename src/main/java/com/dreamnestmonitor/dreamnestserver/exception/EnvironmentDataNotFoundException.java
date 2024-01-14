package com.dreamnestmonitor.dreamnestserver.exception;

public class EnvironmentDataNotFoundException extends RuntimeException {
    public EnvironmentDataNotFoundException() {
        super("Coud not find environment data");
    }
}
