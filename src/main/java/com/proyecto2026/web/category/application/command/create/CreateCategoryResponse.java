package com.proyecto2026.web.category.application.command.create;

import com.proyecto2026.web.category.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateCategoryResponse {
    private Category category;
}
