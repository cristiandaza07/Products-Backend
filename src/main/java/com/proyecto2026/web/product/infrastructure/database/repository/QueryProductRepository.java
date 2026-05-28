package com.proyecto2026.web.product.infrastructure.database.repository;

import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QueryProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
    Page<ProductEntity> findAll(Specification<ProductEntity> specification, Pageable pageable);

    Optional<ProductEntity> findByNameContaining(String name);

    List<ProductEntity> findAllByPriceBetween(Double minPrice, Double maxPrice);

    @EntityGraph(attributePaths = {"productDetailEntity", "reviews", "categories"})
    Optional<ProductEntity> findById(Long id);
}
