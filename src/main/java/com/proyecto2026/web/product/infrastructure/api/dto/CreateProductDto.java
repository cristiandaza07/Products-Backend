package com.proyecto2026.web.product.infrastructure.api.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateProductDto {

    @NotBlank
    private String name;

    @Length(min = 8, max = 255)
    private String description;

    @DecimalMin(value = "0.01", inclusive = false)
    @DecimalMax(value = "999.99", inclusive = false)
    private Double price;

    @NotNull
    private MultipartFile file;
}
