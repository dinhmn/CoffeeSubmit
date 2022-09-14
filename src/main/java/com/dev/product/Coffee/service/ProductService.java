package com.dev.product.Coffee.service;

import com.dev.product.Coffee.Utils.CommonUtils;
import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductEntity insert(ProductEntity product, CategoriesEntity categoriesEntity) throws Exception;
//    ProductEntity insert(ProductEntity productEntity, CategoriesEntity categoriesEntity);
    
    List<ProductEntity> selectAll();
    Optional<ProductEntity> selectProductById(Long id);
    List<ProductEntity> selectProdcutByPriceRange(long min, long max);
    List<ProductEntity> selectProdcutByTitle(String title, Sort sort);
    List<ProductEntity> selectProductBySeoOfCategory(String seo);
    List<ProductEntity> selectProductByPagingAndSortingWithASC(String sortBy, Integer pageNo, Integer pageSize);
    List<ProductEntity> selectProductByPagingAndSortingWithDESC(String sortBy, Integer pageNo, Integer pageSize);
    
    List<ProductEntity> search();

    boolean deleteProductById(Long id);
    ProductEntity update(Long id, ProductEntity product);

}
