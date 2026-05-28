package com.proyecto2026.web.product.application.query.getById;

import com.proyecto2026.web.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetProductByIdResponse {
    private Product product;

}
