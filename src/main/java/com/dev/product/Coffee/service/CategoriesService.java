package com.dev.product.Coffee.service;


import com.dev.product.Coffee.entity.CategoriesEntity;

import java.util.List;

public interface CategoriesService {
    CategoriesEntity createCategories(CategoriesEntity categories);

    List<CategoriesEntity> getAllCategories();

    boolean deleteCategories(Long id);

    CategoriesEntity getCategories(Long id);
    CategoriesEntity updateCategories(Long id, CategoriesEntity categories);
    CategoriesEntity addProductToCategory(Long categoryId, Long productId);
    CategoriesEntity removeProductToCategory(Long categoryId, Long productId);

}
