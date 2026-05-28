package com.proyecto2026.web.product.infrastructure.api.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private String comment;
    private Integer score;
}
