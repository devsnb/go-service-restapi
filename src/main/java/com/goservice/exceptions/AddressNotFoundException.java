package com.goservice.exceptions;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException() {
    }

    public AddressNotFoundException(String message) {
        super(message);
    }
}
