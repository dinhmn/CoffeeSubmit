package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.entity.ContactEntity;
import com.dev.product.Coffee.entity.ReviewsEntity;
import com.dev.product.Coffee.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/r1")
public class ReviewsController {
    
    @Autowired
    private final ReviewsService reviewsService;
    
    @PostMapping("/reviews")
    public ResponseEntity<ReviewsEntity> createReviews(@RequestBody ReviewsEntity reviewsEntity) {
        return ResponseEntity.ok(reviewsService.insert(reviewsEntity));
    }
    
    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewsEntity>> getAllReviews() {
        return ResponseEntity.ok(reviewsService.selectAll());
    }
    
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReviews(@PathVariable Long id) {
        boolean deleted = false;
        deleted = reviewsService.deleteByPrimaryKey(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deleted);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewsEntity> getReviewsId(@PathVariable Long id) {
        ReviewsEntity reviewsEntity = reviewsService.selectByPrimaryKey(id);
        return ResponseEntity.ok(reviewsEntity);
    }
    
    @PutMapping("/reviews/{id}")
    public ResponseEntity<ReviewsEntity> updateReviewsById(@PathVariable Long id,
                                                           @RequestBody ReviewsEntity reviewsEntity) {
        ReviewsEntity reviews = reviewsService.updateByPrimaryKey(id, reviewsEntity);
        return ResponseEntity.ok(reviews);
    }
}
