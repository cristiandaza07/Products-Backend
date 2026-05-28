package com.proyecto2026.web.category.domain.port;

import com.proyecto2026.web.category.domain.entity.Category;

import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Long id);
}
