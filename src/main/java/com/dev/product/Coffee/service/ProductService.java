package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductEntity insert(ProductEntity product, MultipartFile productAvatar, CategoriesEntity categoriesEntity) throws Exception;
    ProductEntity insert(ProductEntity productEntity, CategoriesEntity categoriesEntity);
//    ProductEntity createProduct(ProductEntity product, MultipartFile productAvatar, MultipartFile[] productPictures) throws IOException;
    List<ProductEntity> selectAll();

    ProductEntity selectProductById(Long id);

    boolean deleteProductById(Long id);
    ProductEntity update(Long id, ProductEntity product);

}
