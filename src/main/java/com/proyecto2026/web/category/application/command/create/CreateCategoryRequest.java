package com.proyecto2026.web.category.application.command.create;

import com.proyecto2026.web.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateCategoryRequest implements Request<CreateCategoryResponse> {
    private String name;
}
