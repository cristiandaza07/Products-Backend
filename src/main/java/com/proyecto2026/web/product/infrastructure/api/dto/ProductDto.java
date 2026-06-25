package com.proyecto2026.web.product.infrastructure.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private String targetSpecies;
    private String lifeStage;
    private String brand;
    private List<ReviewDto> reviews;
    private List<String> categories;

}
