package com.matthewwerth.crudweek.controller;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public String ResourceNotFoundException(String message) {
        return message;
    }

    public ResourceNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}

