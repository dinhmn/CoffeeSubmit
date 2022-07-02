package com.dev.product.Coffee.implement;

import com.dev.product.Coffee.entity.ReviewsEntity;
import com.dev.product.Coffee.repository.ReviewsRepository;
import com.dev.product.Coffee.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private final ReviewsRepository reviewsRepository;



    @Override
    public ReviewsEntity createReviews(ReviewsEntity reviewsEntity) {
        reviewsEntity.setCreatedDate(new Date());
        reviewsRepository.save(reviewsEntity);
        return reviewsEntity;
    }

    @Override
    public List<ReviewsEntity> getAllReviews() {
        return reviewsRepository.findAll();
    }

    @Override
    public ReviewsEntity getReviewsById(Long id) {
        Optional<ReviewsEntity> reviewsEntityOptional = reviewsRepository.findById(id);
        ReviewsEntity reviewsEntity = null;
        if (reviewsEntityOptional.isPresent()){
            reviewsEntity = reviewsEntityOptional.get();
        }
        return reviewsEntity;
    }

    @Override
    public boolean deleteReviews(Long id) {
        Optional<ReviewsEntity> reviewsEntityOptional = reviewsRepository.findById(id);
        ReviewsEntity reviewsEntity = null;
        if (reviewsEntityOptional.isPresent()){
            reviewsEntity = reviewsEntityOptional.get();
            reviewsRepository.delete(reviewsEntity);
            return true;
        }
        return false;
    }

    @Override
    public ReviewsEntity updateReviewsById(Long id, ReviewsEntity reviewsEntity) {
        Optional<ReviewsEntity> reviewsEntityOptional = reviewsRepository.findById(id);
        ReviewsEntity reviews = null;
        if (reviewsEntityOptional.isPresent()){
            reviews = reviewsEntityOptional.get();
            reviews.setComment(reviewsEntity.getComment());
            reviews.setEmail(reviewsEntity.getEmail());
            reviews.setName(reviewsEntity.getName());
            reviews.setStatus(reviewsEntity.getStatus());
            reviews.setUpdatedDate(new Date());
            reviewsRepository.save(reviews);
        }
        return reviews;
    }
}
