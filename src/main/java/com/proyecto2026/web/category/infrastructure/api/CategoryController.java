package com.proyecto2026.web.category.infrastructure.api;

import com.proyecto2026.web.category.application.command.create.CreateCategoryRequest;
import com.proyecto2026.web.category.application.command.create.CreateCategoryResponse;
import com.proyecto2026.web.category.domain.entity.Category;
import com.proyecto2026.web.category.infrastructure.api.dto.CreateCategoryDto;
import com.proyecto2026.web.category.infrastructure.api.mapper.CategoryMapper;
import com.proyecto2026.web.common.application.mediator.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "Category", description = "Operations for managing product categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController implements CategoryApi {

    private final Mediator mediator;
    private final CategoryMapper categoryMapper;

    @Operation(summary = "Create category", description = "Create new category")
    @PostMapping("")
    @Override
    public ResponseEntity<Void> saveCategory(@RequestBody @Valid CreateCategoryDto createCategoryDto) {
        log.info("Creating category");

        CreateCategoryRequest request = categoryMapper.mapToCreateCategoryRequest(createCategoryDto);

        CreateCategoryResponse response = mediator.dispatch(request);

        Category category = response.getCategory();

        log.info("Product created with id: {}", category.getId());

        return ResponseEntity.created(URI.create("/api/v1/category/".concat(category.getId().toString()))).build();
    }

}
