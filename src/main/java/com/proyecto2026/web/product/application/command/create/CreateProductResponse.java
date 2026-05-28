package com.proyecto2026.web.product.application.command.create;

import com.proyecto2026.web.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateProductResponse {

    private Product product;
}
