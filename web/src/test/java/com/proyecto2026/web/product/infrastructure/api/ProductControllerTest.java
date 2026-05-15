package com.proyecto2026.web.product.infrastructure.api;

import com.proyecto2026.web.common.mediator.Mediator;
import com.proyecto2026.web.product.application.query.getAll.GetAllProductRequest;
import com.proyecto2026.web.product.application.query.getAll.GetAllProductResponse;
import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.infrastructure.api.dto.ProductDto;
import com.proyecto2026.web.product.infrastructure.api.mapper.ProductMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private Mediator mediator;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductController productController;

    @Test
    public void getAllProducts() {

        GetAllProductResponse getAllProductResponse = new GetAllProductResponse(List.of(
                Product.builder().id(1L).build(),
                Product.builder().id(2L).build()
        ));

        Mockito.when(mediator.dispatch(new GetAllProductRequest())).thenReturn(getAllProductResponse);

        ProductDto productDto = new ProductDto();
        productDto.setId(1L);

        Mockito.when(productMapper.mapToProductDto(Mockito.any(Product.class))).thenReturn(productDto);

        ResponseEntity<List<ProductDto>> response = productController.getAllProducts("5");

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());

        List<ProductDto> products = response.getBody();
        Assertions.assertEquals(2, products.size());

    }

}