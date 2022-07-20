package com.dev.product.Coffee.service;


import com.dev.product.Coffee.entity.CategoriesEntity;

import java.util.List;

public interface CategoriesService {
    CategoriesEntity insert(CategoriesEntity categories);

    List<CategoriesEntity> selectAll();
    List<CategoriesEntity> selectCategoryByPagingAndSortingWithASC(String sortBy, Integer pageNo, Integer pageSize);
    List<CategoriesEntity> selectCategoryByPagingAndSortingWithDESC(String sortBy, Integer pageNo, Integer pageSize);
    boolean deleteByPrimaryKey(Long id);

    CategoriesEntity selectByPrimaryKey(Long id);
    CategoriesEntity updateByPrimaryKey(Long id, CategoriesEntity categories);
    CategoriesEntity addProductToCategory(Long categoryId, Long productId);
    CategoriesEntity removeProductToCategory(Long categoryId, Long productId);

}
