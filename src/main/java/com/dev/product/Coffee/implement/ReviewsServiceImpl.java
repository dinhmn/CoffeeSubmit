package com.dev.product.Coffee.implement;

import com.dev.product.Coffee.entity.ReviewsEntity;
import com.dev.product.Coffee.repository.ReviewsRepository;
import com.dev.product.Coffee.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private final ReviewsRepository reviewsRepository;



    @Override
    public ReviewsEntity createReviews(ReviewsEntity reviewsEntity) {
        reviewsEntity.setCreated_date(new Date());
        reviewsRepository.save(reviewsEntity);
        return reviewsEntity;
    }

    @Override
    public List<ReviewsEntity> getAllReviews() {
        return reviewsRepository.findAll();
    }

    @Override
    public ReviewsEntity getReviewsById(Long id) {
        ReviewsEntity reviewsEntity = reviewsRepository.findById(id).get();
        return reviewsEntity;
    }

    @Override
    public boolean deleteReviews(Long id) {
        ReviewsEntity reviewsEntity = reviewsRepository.findById(id).get();
        reviewsRepository.delete(reviewsEntity);
        return true;
    }

    @Override
    public ReviewsEntity updateReviewsById(Long id, ReviewsEntity reviewsEntity) {
        ReviewsEntity reviews = reviewsRepository.findById(id).get();
        reviews.setComment(reviewsEntity.getComment());
        reviews.setEmail(reviewsEntity.getEmail());
        reviews.setName(reviewsEntity.getName());
        reviews.setStatus(reviewsEntity.getStatus());
        reviews.setUpdated_date(new Date());
        reviewsRepository.save(reviews);
        return reviews;
    }
}
