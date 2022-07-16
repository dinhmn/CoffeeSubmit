package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ReviewsEntity;
import com.dev.product.Coffee.repository.ReviewsRepository;
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
    public ReviewsEntity insert(ReviewsEntity reviewsEntity) {
        reviewsEntity.setCreatedDate(new Date());
        reviewsRepository.save(reviewsEntity);
        return reviewsEntity;
    }
    
    @Override
    public List<ReviewsEntity> insertMultiple(List<ReviewsEntity> reviewsEntityList) {
        return null;
    }
    
    @Override
    public List<ReviewsEntity> selectAll() {
        return reviewsRepository.findAll();
    }
    
    @Override
    public ReviewsEntity selectByPrimaryKey(Long id) {
        Optional<ReviewsEntity> reviewsEntityOptional = reviewsRepository.findById(id);
        ReviewsEntity reviewsEntity = null;
        if (reviewsEntityOptional.isPresent()){
            reviewsEntity = reviewsEntityOptional.get();
        }
        return reviewsEntity;
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
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
    public ReviewsEntity updateByPrimaryKey(Long id, ReviewsEntity reviewsEntity) {
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
