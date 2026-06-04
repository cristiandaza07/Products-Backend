package com.proyecto2026.web.product.infrastructure.database;

import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import com.proyecto2026.web.product.infrastructure.database.repository.QueryProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class ProductRepositoryImplJpaTest {
    @Autowired
    private QueryProductRepository productRepository;

    @Test
    void shouldNotReturnProductWhenNotFound() {
        Optional<ProductEntity> product = productRepository.findById(1L);
        Assertions.assertTrue(product.isEmpty());
    }

    @Test
    void shouldReturnProductWhenFound() {

        ProductEntity productEntity = new ProductEntity();
        ProductEntity savedProduct = productRepository.save(productEntity);

        Optional<ProductEntity> product = productRepository.findById(savedProduct.getId());
        Assertions.assertTrue(product.isPresent());
    }
}