package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ReviewsEntity;

import java.util.List;

public interface ReviewsService {

    ReviewsEntity createReviews(ReviewsEntity reviewsEntity);
    List<ReviewsEntity> getAllReviews();
    ReviewsEntity getReviewsById(Long id);
    boolean deleteReviews(Long id);
    ReviewsEntity updateReviewsById(Long id, ReviewsEntity reviewsEntity);
}
