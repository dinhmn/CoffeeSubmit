package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.repository.ProductRepository;

import com.github.slugify.Slugify;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private final ProductRepository repository;
    private Long id;
    private ProductEntity product;
    
    @Override
    public ProductEntity insert(ProductEntity product, CategoriesEntity categoriesEntity) throws Exception {
        
        product.setCategoriesEntity(categoriesEntity);
        product.setCreatedDate(new Date());
        product.setSeo(new Slugify().slugify(product.getTitle()));
        
        repository.save(product);
        return product;
    }
    
//    @Override
//    public ProductEntity insert(ProductEntity productEntity, CategoriesEntity categoriesEntity) {
//        productEntity.setCreatedDate(new Date());
//        productEntity.setSeo(new Slugify().slugify(productEntity.getTitle()));
//        productEntity.setCategoriesEntity(categoriesEntity);
//        repository.save(productEntity);
//        return productEntity;
//    }
    
    @Override
    public List<ProductEntity> selectAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<ProductEntity> selectProductById(Long id) {
        Optional<ProductEntity> productEntityOptional = repository.findById(id);
        return Optional.ofNullable(productEntityOptional.orElse(null));
    }
    
    @Override
    public List<ProductEntity> selectProdcutByPriceRange(long min, long max) {
        return repository.selectByProductByPriceRange(min, max);
    }
    
    @Override
    public List<ProductEntity> selectProdcutByTitle(String title, Sort sort) {
        return repository.selectProductByTitle(title);
    }
    
    @Override
    public List<ProductEntity> selectProductBySeoOfCategory(String seo) {
        return repository.selectProductBySeoOfCategory(seo);
    }
    
    @Override
    public List<ProductEntity> selectProductByPagingAndSortingWithASC(String sortBy, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        
        Page<ProductEntity> pageResult = repository.findAll(paging);
        
        return pageResult.hasContent() ? pageResult.getContent() : new ArrayList<>();
    }
    
    @Override
    public List<ProductEntity> selectProductByPagingAndSortingWithDESC(String sortBy, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        
        Page<ProductEntity> pageResult = repository.findAll(paging);
        
        return pageResult.hasContent() ? pageResult.getContent() : new ArrayList<>();
    }
    
    @Override
    public List<ProductEntity> search() {
        return null;
    }
    
    @Override
    public boolean deleteProductById(Long id) {
        Optional<ProductEntity> productEntityOptional = repository.findById(id);
        if (productEntityOptional.isPresent()) {
            ProductEntity productEntity = productEntityOptional.get();
            repository.delete(productEntity);
            return true;
        }
        
        return false;
    }

    @Override
    public ProductEntity update(Long id, ProductEntity product) {
        Optional<ProductEntity> productEntityOptional = repository.findById(id);
        ProductEntity productEntity = null;
        if (productEntityOptional.isPresent()) {
            productEntity = productEntityOptional.get();
            productEntity.setTitle(product.getTitle());
            productEntity.setDetailsDescription(product.getDetailsDescription());
            productEntity.setSeo(product.getSeo());
            productEntity.setCreatedDate(product.getCreatedDate());
            productEntity.setPrice(product.getPrice());
            productEntity.setPriceSale(product.getPriceSale());
            productEntity.setQuantity(product.getQuantity());
            productEntity.setShortDescription(product.getShortDescription());
            productEntity.setCreatedBy(product.getCreatedBy());
            productEntity.setUpdatedBy(product.getUpdatedBy());
            productEntity.setUpdatedDate(new Date());
            productEntity.setStatus(product.getStatus());
            productEntity.setCategoriesEntity(productEntity.getCategoriesEntity());
            repository.save(productEntity);
        }
        return productEntity;
    }
/*    productEntity = productEntityOptional.get();
            productEntity.setTitle(Objects.nonNull(product.getTitle()) ? product.getTitle() : productEntity.getTitle());
            productEntity.setDetailsDescription(Objects.nonNull(product.getDetailsDescription()) ? product.getDetailsDescription() : productEntity.getDetailsDescription());
            productEntity.setSeo(Objects.nonNull(product.getSeo()) ? product.getSeo() : productEntity.getTitle());
            productEntity.setCreatedDate(product.getCreatedDate());
            productEntity.setPrice(Objects.nonNull(product.getPrice()) ? product.getPrice() : productEntity.getPrice());
            productEntity.setPriceSale(Objects.nonNull(product.getPriceSale()) ? product.getPriceSale() : productEntity.getPriceSale());
            productEntity.setQuantity(Objects.nonNull(product.getQuantity()) ? product.getQuantity() : productEntity.getQuantity());
            productEntity.setShortDescription(Objects.nonNull(product.getShortDescription()) ? product.getShortDescription() : productEntity.getShortDescription());
            productEntity.setCreatedBy(product.getCreatedBy());
            productEntity.setUpdatedBy(product.getUpdatedBy());
            productEntity.setUpdatedDate(new Date());
            productEntity.setStatus(Objects.nonNull(product.getStatus()) ? product.getStatus() : productEntity.getStatus());
            productEntity.setCategoriesEntity(Objects.nonNull(productEntity.getCategoriesEntity()) ? productEntity.getCategoriesEntity() : productEntity.getCategoriesEntity());
            repository.save(productEntity);*/

}
