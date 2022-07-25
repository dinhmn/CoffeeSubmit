package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ImageService {
    ImageEntity insert(MultipartFile file,  ProductEntity productEntity) throws Exception;

    List<ImageEntity> selectAll();
    ImageEntity selectImageById(String id) throws Exception;

    ImageEntity update(MultipartFile file, ImageEntity productId, Long productEntity) throws Exception;

    void delete(MultipartFile file, Long productId) throws Exception;
}
