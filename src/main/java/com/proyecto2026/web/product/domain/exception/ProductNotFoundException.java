package com.proyecto2026.web.product.domain.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {

        super("El producto con id " + id + " no existe");
    }
}
