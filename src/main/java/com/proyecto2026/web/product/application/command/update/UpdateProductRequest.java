package com.proyecto2026.web.product.application.command.update;

import com.proyecto2026.web.common.application.mediator.Request;
import com.proyecto2026.web.review.domain.entity.Review;
import lombok.Data;

@Data
public class UpdateProductRequest implements Request<Void> {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String provider;
    private Review review;
    private Long categoryId;
}
