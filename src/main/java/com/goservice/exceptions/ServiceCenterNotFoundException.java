package com.goservice.exceptions;

public class ServiceCenterNotFoundException extends RuntimeException {
    public ServiceCenterNotFoundException() {
    }

    public ServiceCenterNotFoundException(String message) {
        super(message);
    }
}
