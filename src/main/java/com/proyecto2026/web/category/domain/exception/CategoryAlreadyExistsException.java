package com.proyecto2026.web.category.domain.exception;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String nameCategory) {
        super("La categoria con nombre " + nameCategory + " ya existe");
    }
}
