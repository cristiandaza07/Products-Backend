package com.proyecto2026.web.category.infrastructure.database;

import com.proyecto2026.web.category.domain.entity.Category;
import com.proyecto2026.web.category.domain.port.CategoryRepository;
import com.proyecto2026.web.category.infrastructure.database.mapper.CategoryEntityMapper;
import com.proyecto2026.web.category.infrastructure.database.repository.QueryCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CategoryRepositoryImpl implements CategoryRepository {

    private final QueryCategoryRepository queryCategoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Cacheable(value = "categories", key = "#id")
    @Override
    public Optional<Category> findById(Long id) {
        return queryCategoryRepository.findById(id).map(categoryEntityMapper::mapToCategory);
    }
}
