package com.example.salud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoutException extends RuntimeException {
    public ModelNotFoutException(String message) {
        super(message);
    }
}
