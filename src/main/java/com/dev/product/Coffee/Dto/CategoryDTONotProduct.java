package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.CategoriesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTONotProduct extends BaseDTO{
    
    private String categoriesName;
    private String title;
    private String seo;
    private String description;
    
    public static CategoryDTONotProduct fromToDTO(CategoriesEntity category) {
        CategoryDTONotProduct categoryDTO = new CategoryDTONotProduct();
        
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoriesName(category.getCategoriesName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setTitle(category.getTitle());
        categoryDTO.setSeo(category.getSeo());
        categoryDTO.setCreatedBy(category.getCreatedBy());
        categoryDTO.setCreatedDate(category.getCreatedDate());
        categoryDTO.setUpdatedBy(category.getUpdatedBy());
        categoryDTO.setUpdatedDate(category.getUpdatedDate());
        categoryDTO.setStatus(category.getStatus());
        return categoryDTO;
    }
}
