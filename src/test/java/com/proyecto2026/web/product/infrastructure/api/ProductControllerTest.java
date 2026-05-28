package com.proyecto2026.web.product.infrastructure.api;

import com.proyecto2026.web.common.application.mediator.Mediator;
import com.proyecto2026.web.product.infrastructure.api.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

//        GetAllProductResponse getAllProductResponse = new GetAllProductResponse(new PaginationResult<>(
//                List.of(
//                        Product.builder().id(1L).build(),
//                        Product.builder().id(2L).build()
//                ),
//        )
//
//
//        );
//
//        Mockito.when(mediator.dispatch(new GetAllProductRequest())).thenReturn(getAllProductResponse);
//
//        ProductDto productDto = new ProductDto();
//        productDto.setId(1L);
//
//        Mockito.when(productMapper.mapToProductDto(Mockito.any(Product.class))).thenReturn(productDto);
//
//        ResponseEntity<PaginationResult<ProductDto>> response = productController.getAllProducts(0, 5);
//
//        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
//        Assertions.assertNotNull(response.getBody());
//
//        PaginationResult<ProductDto> products = response.getBody();
//        Assertions.assertEquals(2, products.getContent().size());

    }

}