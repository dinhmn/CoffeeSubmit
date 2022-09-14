package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;

public interface ImageService {
    ImageEntity insert(MultipartFile file, Optional<ProductEntity> productEntity) throws Exception;

    List<ImageEntity> selectAll();
    ImageEntity selectImageById(Long id) throws Exception;

    ImageEntity update(MultipartFile file, ImageEntity imageEntity, ProductEntity productEntity) throws Exception;

    void delete(MultipartFile file, Long productId) throws Exception;
}
