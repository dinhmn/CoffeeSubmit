package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ImageEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ImageEntity saveImage(MultipartFile file) throws Exception;

    ImageEntity getImage(String id) throws Exception;
//    ImageEntity createImage(MultipartFile file);
}
