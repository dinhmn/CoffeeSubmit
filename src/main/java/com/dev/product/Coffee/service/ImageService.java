package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ImageEntity saveImage(MultipartFile file,  ProductEntity productEntity
    ) throws Exception;

    ImageEntity getImage(String id) throws Exception;

    ImageEntity updateImage(MultipartFile file, ProductEntity productEntity) throws Exception;
//    ImageEntity createImage(MultipartFile file);
}
