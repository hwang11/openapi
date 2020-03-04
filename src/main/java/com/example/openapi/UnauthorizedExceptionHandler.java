package com.example.openapi;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class UnauthorizedExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public Object custom(HttpClientErrorException.Unauthorized e) {
        return e.getMessage();
    }
}

