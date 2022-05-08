package com.dev.product.Coffee.entity;


import com.dev.product.Coffee.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "tbl_category")
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesEntity extends BaseEntity{

    private String categoriesName;
    private String title;
    private String seo;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoriesEntity")
//    private Set<ProductEntity> productEntities = new HashSet<>();
    private List<ProductEntity> productEntities = new ArrayList<ProductEntity>();

    public void add(ProductEntity productEntity){
        productEntities.add(productEntity);
    }
    public void remove(ProductEntity productEntity){
        productEntities.remove(productEntity);
    }
    public static CategoriesEntity from(CategoryDTO categoryDTO){
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
}
