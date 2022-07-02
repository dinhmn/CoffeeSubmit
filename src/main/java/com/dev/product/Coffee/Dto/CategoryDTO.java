package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.CategoriesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO extends com.dev.product.Coffee.dto.BaseDTO {
    private String categoriesName;
    private String title;
    private String seo;
    private String description;

    private List<ProductDTO> productDTOList = new ArrayList<>();

    public static CategoryDTO from(CategoriesEntity category) {
        CategoryDTO categoryDTO = new CategoryDTO();

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
        categoryDTO.setProductDTOList(category.getProductEntities().stream().map(ProductDTO::from).collect(Collectors.toList()));
        return categoryDTO;
    }
}
