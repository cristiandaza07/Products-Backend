package com.proyecto2026.web.review.infrastructure.database;

import com.proyecto2026.web.review.domain.entity.Review;
import com.proyecto2026.web.review.domain.port.ReviewRepository;
import com.proyecto2026.web.review.infrastructure.database.entity.ReviewEntity;
import com.proyecto2026.web.review.infrastructure.database.mapper.ReviewEntityMapper;
import com.proyecto2026.web.review.infrastructure.database.repository.QueryReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReviewRepositoryImpl implements ReviewRepository {
    private final QueryReviewRepository queryReviewRepository;

    private final ReviewEntityMapper reviewEntityMapper;

    @Override
    public Review save(Review review) {
        ReviewEntity reviewEntity = reviewEntityMapper.mapToReviewEntity(review);
        ReviewEntity save = queryReviewRepository.save(reviewEntity);
        return reviewEntityMapper.mapToReview(save);
    }
}
