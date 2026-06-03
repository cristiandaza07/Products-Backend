package com.proyecto2026.web.product.application.command.assignCategory;

import com.proyecto2026.web.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AssignCategoryRequest implements Request<Void> {
    private String categoryName;
    private Long productId;
}
