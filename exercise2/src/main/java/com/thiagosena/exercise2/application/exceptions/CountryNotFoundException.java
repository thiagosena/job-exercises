package com.thiagosena.exercise2.application.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String msg) {
        super(msg);
    }
}
