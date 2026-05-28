package com.proyecto2026.web.category.domain.entity;

import com.proyecto2026.web.product.domain.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Category {
    private Long id;
    private String name;

    private List<Product> products;
}
