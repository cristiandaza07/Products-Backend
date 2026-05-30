package com.proyecto2026.web.review.domain.entity;

import com.proyecto2026.web.product.domain.entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {
    private Long id;
    private String comment;
    private Integer score;

    private Product product;
}
