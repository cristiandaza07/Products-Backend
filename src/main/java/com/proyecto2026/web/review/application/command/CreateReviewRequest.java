package com.proyecto2026.web.review.application.command;

import com.proyecto2026.web.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateReviewRequest implements Request<CreateReviewResponse> {
    private String comment;
    private Integer score;
    private Long productId;
}
