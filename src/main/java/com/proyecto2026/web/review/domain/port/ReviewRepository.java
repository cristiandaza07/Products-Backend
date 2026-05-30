package com.proyecto2026.web.review.domain.port;

import com.proyecto2026.web.review.domain.entity.Review;

public interface ReviewRepository {
    Review save(Review review);

}
