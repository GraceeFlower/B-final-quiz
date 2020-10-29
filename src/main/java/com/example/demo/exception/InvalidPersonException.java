package com.example.demo.exception;

public class InvalidPersonException extends RuntimeException {

    public InvalidPersonException() {
    }

    public InvalidPersonException(String message) {
        super(message);
    }
}
