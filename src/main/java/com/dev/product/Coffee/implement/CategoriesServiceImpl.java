package com.dev.product.Coffee.implement;

import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.exception.ProductIsAlrealdyAssignedException;
import com.dev.product.Coffee.repository.CategoriesRepository;
import com.dev.product.Coffee.repository.ProductRepository;
import com.dev.product.Coffee.service.CategoriesService;
import com.dev.product.Coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.github.slugify.Slugify;
import org.springframework.transaction.annotation.Transactional;

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
        categories.setCreated_date(new Date());
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
        CategoriesEntity categoriesEntity = categoriesRepository.findById(id).get();
        categoriesRepository.delete(categoriesEntity);
        return true;
    }

    @Override
    public CategoriesEntity getCategories(Long id) {
        CategoriesEntity categoriesEntity = categoriesRepository.findById(id).get();
        return categoriesEntity;
    }

    @Override
    public CategoriesEntity updateCategories(Long id, CategoriesEntity categories) {
        CategoriesEntity cat = categoriesRepository.findById(id).get();
        cat.setCategoriesName(categories.getCategoriesName());
        cat.setDescription(categories.getDescription());
        cat.setTitle(categories.getTitle());
        cat.setSeo(categories.getSeo());
        cat.setStatus(categories.getStatus());
        cat.setUpdated_date(categories.getCreated_date());
        cat.setCreated_date(new Date());
        categoriesRepository.save(categories);
        return categories;
    }

    @Override
    public CategoriesEntity addProductToCategory(Long categoryId, Long productId) {
        CategoriesEntity categoriesEntity = categoriesRepository.getById(categoryId);
        ProductEntity productEntity = productRepository.getById(productId);

        if (Objects.nonNull(productEntity.getCategoriesEntity())){
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
