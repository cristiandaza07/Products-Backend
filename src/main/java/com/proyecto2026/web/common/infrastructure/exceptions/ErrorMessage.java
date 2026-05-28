package com.proyecto2026.web.common.infrastructure.exceptions;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorMessage {
    private String message;
    private String exception;
    private String path;
    private Map<String, String> errors;

    public ErrorMessage(Map<String, String> errors, String message, String exception, String path) {
        this.errors = errors;
        this.message = message;
        this.exception = exception;
        this.path = path;

    }

    public ErrorMessage(String message, String exception, String path) {
        this.message = message;
        this.exception = exception;
        this.path = path;
        this.errors = new HashMap<>();
    }


}
