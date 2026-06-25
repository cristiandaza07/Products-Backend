package com.proyecto2026.web.product.domain.exception;

public class InvalidLifeStageException extends RuntimeException {
    public InvalidLifeStageException(String lifeStage) {

        super("Ingresa un valor valido para la etapa de vida del perro o gato, " + lifeStage + " no es valido. Los valores validos son: 'PUPPY_KITTEN', 'ADULT', 'SENIOR' o 'ALL_STAGES'");
    }
}
