package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {

    ProductEntity insert(ProductEntity product, MultipartFile productAvatar, CategoriesEntity categoriesEntity) throws Exception;
    ProductEntity insert(ProductEntity productEntity, CategoriesEntity categoriesEntity);
    
    List<ProductEntity> selectAll();
    ProductEntity selectProductById(Long id);
    List<ProductEntity> selectProductByPrice(String price, Integer pageNo, Integer pageSize);
    List<ProductEntity> selectProductByProductName(String productName, Integer pageNo, Integer pageSize);
    List<ProductEntity> selectProductByBaseDate(LocalDateTime baseDate, Integer pageNo, Integer pageSize);
    

    boolean deleteProductById(Long id);
    ProductEntity update(Long id, ProductEntity product);

}
