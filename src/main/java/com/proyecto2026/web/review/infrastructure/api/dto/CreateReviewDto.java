package com.proyecto2026.web.review.infrastructure.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class CreateReviewDto {
    @Range(min = 1, max = 5, message = "The score must be between 1 and 5")
    private Integer score;
    @Length(min = 4, max = 255)
    private String comment;
}
