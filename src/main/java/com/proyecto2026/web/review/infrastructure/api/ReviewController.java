package com.proyecto2026.web.review.infrastructure.api;

import com.proyecto2026.web.common.application.mediator.Mediator;
import com.proyecto2026.web.review.application.command.CreateReviewRequest;
import com.proyecto2026.web.review.application.command.CreateReviewResponse;
import com.proyecto2026.web.review.domain.entity.Review;
import com.proyecto2026.web.review.infrastructure.api.dto.CreateReviewDto;
import com.proyecto2026.web.review.infrastructure.api.mapper.ReviewMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/products/{productId}/reviews")
@Tag(name = "Review", description = "Review API operations")
@RequiredArgsConstructor
@Slf4j
public class ReviewController implements ReviewApi {

    private final Mediator mediator;
    private final ReviewMapper reviewMapper;

    @Operation(summary = "Create product review", description = "Create review")
    @PostMapping("")
    @Override
    public ResponseEntity<Void> saveReview(
            @PathVariable Long productId,
            @RequestBody @Valid CreateReviewDto createReviewDto) {

        log.info("Creating product");

        CreateReviewRequest request = reviewMapper.mapToCreateReviewRequest(createReviewDto, productId);

        CreateReviewResponse response = mediator.dispatch(request);

        Review review = response.getReview();

        log.info("Review created with id: {}", review.getId());

        return ResponseEntity.created(URI.create("/api/v1/reviews/".concat(review.getId().toString()))).build();
    }
}
