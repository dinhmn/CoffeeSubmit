package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.ReviewsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author DinhMN
 */

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
        revi.setCreatedBy(reviewsEntity.getCreatedBy());
        revi.setCreatedDate(reviewsEntity.getCreatedDate());
        revi.setUpdatedDate(reviewsEntity.getUpdatedDate());
        revi.setUpdatedBy(reviewsEntity.getUpdatedBy());
        revi.setStatus(reviewsEntity.getStatus());
        revi.setId(reviewsEntity.getId());
        return revi;
    }
}
