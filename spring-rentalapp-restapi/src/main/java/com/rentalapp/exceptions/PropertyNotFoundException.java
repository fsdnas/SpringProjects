package com.rentalapp.exceptions;

public class PropertyNotFoundException extends RuntimeException {
    public PropertyNotFoundException() {
    }

    public PropertyNotFoundException(String message) {
        super(message);
    }
}
