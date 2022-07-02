package com.dev.product.Coffee.Dto;

import com.dev.product.Coffee.entity.ReviewsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsDTO extends BaseDTO{
    private String comment;
    private String name;
    private String email;

    public static ReviewsDTO from(ReviewsEntity reviewsEntity){
        ReviewsDTO revi = new ReviewsDTO();
        revi.setComment(reviewsEntity.getComment());
        revi.setEmail(reviewsEntity.getEmail());
        revi.setName(reviewsEntity.getName());
        revi.setCreated_by(reviewsEntity.getCreated_by());
        revi.setCreated_date(reviewsEntity.getCreated_date());
        revi.setUpdated_date(reviewsEntity.getUpdated_date());
        revi.setUpdated_by(reviewsEntity.getUpdated_by());
        revi.setStatus(reviewsEntity.getStatus());
        revi.setId(reviewsEntity.getId());
        return revi;
    }
}
