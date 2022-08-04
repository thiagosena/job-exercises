package com.thiagosena.exercise2.application.exceptions.handler;

import com.thiagosena.exercise2.application.exceptions.CountryNotFoundException;
import com.thiagosena.exercise2.application.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<?> handleCountryNotFoundException(CountryNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                "Country not found",
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                new Date().getTime()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        ErrorResponse error = new ErrorResponse(
                "Method not allowed",
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                ex.getMessage(),
                new Date().getTime()
        );
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                new Date().getTime()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
