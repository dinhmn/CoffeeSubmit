package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ReviewsEntity;

import java.util.List;

public interface ReviewsService {

    ReviewsEntity insert(ReviewsEntity reviewsEntity);
    List<ReviewsEntity> insertMultiple(List<ReviewsEntity> reviewsEntityList);
    List<ReviewsEntity> selectAll();
    
    ReviewsEntity selectByPrimaryKey(Long id);
    
    boolean deleteByPrimaryKey(Long id);
    ReviewsEntity updateByPrimaryKey(Long id, ReviewsEntity reviewsEntity);
}
