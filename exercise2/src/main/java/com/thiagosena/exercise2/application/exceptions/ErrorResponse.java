package com.thiagosena.exercise2.application.exceptions;

public record ErrorResponse(String title, int status, String detail,
                            long timestamp) {
}
