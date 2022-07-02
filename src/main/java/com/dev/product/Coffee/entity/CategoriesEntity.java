package com.dev.product.Coffee.entity;


import com.dev.product.Coffee.dto.CategoryDTO;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_category")
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesEntity extends BaseEntity {

    private String categoriesName;
    private String title;
    private String seo;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoriesEntity")
    @ToString.Exclude
    private List<ProductEntity> productEntities = new ArrayList<>();

    public void add(ProductEntity productEntity) {
        productEntities.add(productEntity);
    }

    public void remove(ProductEntity productEntity) {
        productEntities.remove(productEntity);
    }

    public static CategoriesEntity from(CategoryDTO categoryDTO) {
        CategoriesEntity cat = new CategoriesEntity();
        cat.setId(categoryDTO.getId());
        cat.setCategoriesName(categoryDTO.getCategoriesName());
        cat.setDescription(categoryDTO.getDescription());
        cat.setTitle(categoryDTO.getTitle());
        cat.setSeo(categoryDTO.getSeo());
        cat.setCreated_by(categoryDTO.getCreated_by());
        cat.setCreated_date(categoryDTO.getCreated_date());
        cat.setUpdated_by(categoryDTO.getUpdated_by());
        cat.setUpdated_date(categoryDTO.getUpdated_date());
        cat.setStatus(categoryDTO.getStatus());
        return cat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoriesEntity that = (CategoriesEntity) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 1285280852;
    }
}
