package com.proyecto2026.web.product.domain.port;

import com.proyecto2026.web.common.domain.PaginationQuery;
import com.proyecto2026.web.common.domain.PaginationResult;
import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.domain.entity.ProductFilter;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(Long id);

    PaginationResult<Product> findAll(PaginationQuery paginationQuery, ProductFilter productFilter);

    void deleteById(Long id);
}
