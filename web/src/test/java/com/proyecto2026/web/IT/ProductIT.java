package com.proyecto2026.web.IT;

import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.domain.port.ProductRepository;
import com.proyecto2026.web.product.infrastructure.api.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
@AutoConfigureMockMvc
public class ProductIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        log.info("Setting up integration test");
        productRepository.save(
                Product.builder().id(1L).name("Product 1").description("Description 1").price(100.0).build()
        );
    }

    @AfterEach
    void tearDown() {
        log.info("Tearing down integration test");
        productRepository.deleteById(1L);
    }

    @Test
    public void getProductByIdExits() {
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("/api/v1/products/1", ProductDto.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("Product 1", response.getBody().getName());
        Assertions.assertEquals("Description 1", response.getBody().getDescription());
        Assertions.assertEquals(100.0, response.getBody().getPrice());
    }

    @Test
    public void saveProduct() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "image.jpeg", "image/jpeg", "image".getBytes());

        mockMvc.perform(
                MockMvcRequestBuilders.multipart(HttpMethod.POST, "/api/v1/products")
                        .file(file)
                        .param("id", "2")
                        .param("name", "Name 2")
                        .param("description", "Description 2")
                        .param("price", "150.00")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
