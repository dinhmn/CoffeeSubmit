package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductEntity createProduct(ProductEntity product, MultipartFile productAvatar) throws Exception;
//    ProductEntity createProduct(ProductEntity product, MultipartFile productAvatar, MultipartFile[] productPictures) throws IOException;
    List<ProductEntity> getAllProducts();

    ProductEntity getProductById(Long id);

    boolean deleteProduct(Long id);
//    Product updateProductById(Long id, Product product, MultipartFile productAvatar,MultipartFile[] productPictures) throws IOException;

}
