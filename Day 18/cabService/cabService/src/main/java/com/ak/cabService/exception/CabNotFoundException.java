package com.ak.cabService.exception;

public class CabNotFoundException extends RuntimeException {
    public CabNotFoundException(String message) {
        super(message);
    }
}