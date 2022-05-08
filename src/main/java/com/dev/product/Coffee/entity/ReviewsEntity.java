package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_reviews")
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsEntity extends BaseEntity{

    private String comment;
    private String name;
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntity productCmt;
}
