package com.proyecto2026.web.category.infrastructure.database.repository;

import com.proyecto2026.web.category.infrastructure.database.entity.CategoryEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueryCategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @EntityGraph(attributePaths = "products")
    Optional<CategoryEntity> findById(Long id);

    @EntityGraph(attributePaths = "products")
    Optional<CategoryEntity> findByName(String name);
}
