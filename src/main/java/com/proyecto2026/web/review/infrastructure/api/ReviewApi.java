package com.proyecto2026.web.review.infrastructure.api;

import com.proyecto2026.web.review.infrastructure.api.dto.CreateReviewDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ReviewApi {
    ResponseEntity<Void> saveReview(@PathVariable Long productId, @RequestBody CreateReviewDto createReviewDto);
}
