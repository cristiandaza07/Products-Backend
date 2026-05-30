package com.proyecto2026.web.review.application.command;

import com.proyecto2026.web.review.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateReviewResponse {
    private Review review;
}
