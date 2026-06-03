package com.proyecto2026.web.product.infrastructure.api;

import com.proyecto2026.web.common.domain.PaginationResult;
import com.proyecto2026.web.product.infrastructure.api.dto.CreateProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.ProductDto;
import com.proyecto2026.web.product.infrastructure.api.dto.UpdateProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductApi {
    ResponseEntity<PaginationResult<ProductDto>> getAllProducts(
            int pageNumber, int pageSize, String sortBy, String direction, String name, String description, Double priceMin, Double priceMax);

    ResponseEntity<ProductDto> getProductById(@PathVariable Long id);

    ResponseEntity<Void> saveProduct(@RequestBody CreateProductDto createProductDto);

    ResponseEntity<Void> updateProduct(@RequestBody UpdateProductDto updateProductDto);

    ResponseEntity<Void> deleteProduct(@PathVariable Long id);

    ResponseEntity<Void> assignCategory(@PathVariable String categoryName, Long productId);

}
