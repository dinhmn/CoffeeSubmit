package com.dev.product.Coffee.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author DinhMN
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_reviews")
public class ReviewsEntity extends BaseEntity {
    
    private String name;
    private String email;
    private String comment;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReviewsEntity that = (ReviewsEntity) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 378756973;
    }
}
