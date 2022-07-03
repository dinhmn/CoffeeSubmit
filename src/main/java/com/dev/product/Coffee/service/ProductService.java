package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductEntity createProduct(ProductEntity product, MultipartFile productAvatar, CategoriesEntity categoriesEntity) throws Exception;
    ProductEntity create(ProductEntity productEntity, CategoriesEntity categoriesEntity);
//    ProductEntity createProduct(ProductEntity product, MultipartFile productAvatar, MultipartFile[] productPictures) throws IOException;
    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(Long id);

    boolean deleteProduct(Long id);
    ProductEntity updateProductById(Long id, ProductEntity product);

}
