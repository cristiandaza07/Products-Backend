package com.proyecto2026.web.review.infrastructure.database.repository;

import com.proyecto2026.web.review.infrastructure.database.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
