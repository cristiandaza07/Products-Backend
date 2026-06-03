package com.proyecto2026.web.product.application.command.create;

import com.proyecto2026.web.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Data
public class CreateProductRequest implements Request<CreateProductResponse> {

    private String name;
    private String description;
    private Double price;
    private MultipartFile file;
    private String provider;
    private String warranty;
    private String specifications;
}
