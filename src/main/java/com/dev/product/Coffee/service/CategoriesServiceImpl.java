package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.exception.ProductIsAlrealdyAssignedException;
import com.dev.product.Coffee.repository.CategoriesRepository;
import com.dev.product.Coffee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

import com.github.slugify.Slugify;

@RequiredArgsConstructor
@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private final CategoriesRepository repository;
    @Autowired
    private final ProductRepository productRepository;

    @Override
    public CategoriesEntity insert(CategoriesEntity categories) {
        categories.setCreatedDate(new Date());
        categories.setSeo(new Slugify().slugify(categories.getTitle()));
        repository.save(categories);
        return categories;
    }

    @Override
    public List<CategoriesEntity> selectAll() {
        return repository.findAll();
    }
    
    @Override
    public List<CategoriesEntity> selectCategoryByPagingAndSortingWithASC(String sortBy, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        
        Page<CategoriesEntity> pageResult = repository.findAll(paging);
        
        return pageResult.hasContent() ? pageResult.getContent() : new ArrayList<>();
    }
    
    @Override
    public List<CategoriesEntity> selectCategoryByPagingAndSortingWithDESC(String sortBy, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
    
        Page<CategoriesEntity> pageResult = repository.findAll(paging);
    
        return pageResult.hasContent() ? pageResult.getContent() : new ArrayList<>();
    }
    
    
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        Optional<CategoriesEntity> categoriesEntityOptional = repository.findById(id);
        CategoriesEntity categoriesEntity;
        if (categoriesEntityOptional.isPresent()) {
            categoriesEntity = categoriesEntityOptional.get();
            repository.delete(categoriesEntity);
            return true;
        }
        return false;
    }

    @Override
    public CategoriesEntity selectByPrimaryKey(Long id) {
        Optional<CategoriesEntity> categoriesEntityOptional = repository.findById(id);
        CategoriesEntity categoriesEntity = null;
        if (categoriesEntityOptional.isPresent()) {
            categoriesEntity = categoriesEntityOptional.get();
        }
        return categoriesEntity;
    }

    @Override
    public CategoriesEntity updateByPrimaryKey(Long id, CategoriesEntity categories) {
        Optional<CategoriesEntity> categoriesEntityOptional = repository.findById(id);
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

        repository.save(categories);
        return categories;
    }

    @Override
    public CategoriesEntity addProductToCategory(Long categoryId, Long productId) {
        CategoriesEntity categoriesEntity = repository.getById(categoryId);
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
        CategoriesEntity categoriesEntity = repository.getById(categoryId);
        ProductEntity productEntity = productRepository.getById(productId);
        categoriesEntity.remove(productEntity);
        return categoriesEntity;
    }


}
