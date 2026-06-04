package com.proyecto2026.web.product.infrastructure.database;

import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import com.proyecto2026.web.product.infrastructure.database.mapper.ProductEntityMapper;
import com.proyecto2026.web.product.infrastructure.database.repository.QueryProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryImplTest {
    @Mock
    private QueryProductRepository productRepository;
    @Mock
    private ProductEntityMapper productEntityMapper;
    @InjectMocks
    private ProductRepositoryImpl productRepositoryImpl;

    @Test
    void shouldNotReturnProductWhenNotFound() {
        Optional<Product> product = productRepositoryImpl.findById(1L);
        Assertions.assertTrue(product.isEmpty());
    }

    @Test
    void shouldReturnProductWhenFound() {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(new ProductEntity()));
        Mockito.when(productEntityMapper.mapToProduct(any(ProductEntity.class))).thenReturn(Product.builder().id(1L).build());


        Optional<Product> product = productRepositoryImpl.findById(1L);
        Assertions.assertTrue(product.isPresent());
    }
}