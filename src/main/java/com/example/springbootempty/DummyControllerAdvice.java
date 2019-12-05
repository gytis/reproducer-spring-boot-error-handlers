package com.example.springbootempty;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DummyControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public Error runtimeExceptionHandler(Throwable t) {
        return new Error(t.getMessage());
    }
}
