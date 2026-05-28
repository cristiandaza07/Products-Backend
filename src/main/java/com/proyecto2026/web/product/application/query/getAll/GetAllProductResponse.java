package com.proyecto2026.web.product.application.query.getAll;

import com.proyecto2026.web.common.domain.PaginationResult;
import com.proyecto2026.web.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetAllProductResponse {
    private PaginationResult<Product> productsPage;

}
