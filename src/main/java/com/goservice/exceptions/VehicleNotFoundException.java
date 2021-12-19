package com.goservice.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException() {
    }

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
