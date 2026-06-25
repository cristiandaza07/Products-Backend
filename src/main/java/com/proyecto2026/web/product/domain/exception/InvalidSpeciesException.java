package com.proyecto2026.web.product.domain.exception;

public class InvalidSpeciesException extends RuntimeException {
    public InvalidSpeciesException(String species) {
        super("La especie ´" + species + "´ no es valida, tiene que ser 'DOG' o 'CAT'");
    }
}
