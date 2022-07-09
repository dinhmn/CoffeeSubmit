package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.exception.ProductIsAlrealdyAssignedException;
import com.dev.product.Coffee.repository.CategoriesRepository;
import com.dev.product.Coffee.repository.ProductRepository;
import com.dev.product.Coffee.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.github.slugify.Slugify;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private final CategoriesRepository categoriesRepository;
    @Autowired
    private ProductRepository productRepository;

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public CategoriesEntity createCategories(CategoriesEntity categories) {
        categories.setCreatedDate(new Date());
        categories.setSeo(new Slugify().slugify(categories.getTitle()));
        categoriesRepository.save(categories);
        return categories;
    }


    @Override
    public List<CategoriesEntity> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public boolean deleteCategories(Long id) {
        Optional<CategoriesEntity> categoriesEntityOptional = categoriesRepository.findById(id);
        CategoriesEntity categoriesEntity;
        if (categoriesEntityOptional.isPresent()) {
            categoriesEntity = categoriesEntityOptional.get();
            categoriesRepository.delete(categoriesEntity);
            return true;
        }
        return false;
    }

    @Override
    public CategoriesEntity getCategories(Long id) {
        Optional<CategoriesEntity> categoriesEntityOptional = categoriesRepository.findById(id);
        CategoriesEntity categoriesEntity = null;
        if (categoriesEntityOptional.isPresent()) {
            categoriesEntity = categoriesEntityOptional.get();
        }
        return categoriesEntity;
    }

    @Override
    public CategoriesEntity updateCategories(Long id, CategoriesEntity categories) {
        Optional<CategoriesEntity> categoriesEntityOptional = categoriesRepository.findById(id);
        CategoriesEntity categoriesEntity = null;
        if (categoriesEntityOptional.isPresent()) {
            categoriesEntity = categoriesEntityOptional.get();
            categoriesEntity.setCategoriesName(categories.getCategoriesName());
            categoriesEntity.setDescription(categories.getDescription());
            categoriesEntity.setTitle(categories.getTitle());
            categoriesEntity.setSeo(categories.getSeo());
            categoriesEntity.setStatus(categories.getStatus());
            categoriesEntity.setUpdatedDate(categories.getCreatedDate());
            categoriesEntity.setCreatedDate(new Date());
        }

        categoriesRepository.save(categories);
        return categories;
    }

    @Override
    public CategoriesEntity addProductToCategory(Long categoryId, Long productId) {
        CategoriesEntity categoriesEntity = categoriesRepository.getById(categoryId);
        ProductEntity productEntity = productRepository.getById(productId);

        if (Objects.nonNull(productEntity.getCategoriesEntity())) {
            throw new ProductIsAlrealdyAssignedException(productId, productEntity.getCategoriesEntity().getId());
        }
        categoriesEntity.add(productEntity);
        productEntity.setCategoriesEntity(categoriesEntity);
        return categoriesEntity;
    }

    @Override
    public CategoriesEntity removeProductToCategory(Long categoryId, Long productId) {
        CategoriesEntity categoriesEntity = categoriesRepository.getById(categoryId);
        ProductEntity productEntity = productRepository.getById(productId);
        categoriesEntity.remove(productEntity);
        return categoriesEntity;
    }


}
