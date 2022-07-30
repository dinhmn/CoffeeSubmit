package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.ProductImagesEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductImagesService {

    public boolean isEmptyUploadFile(MultipartFile[] images);
    public boolean isEmptyUploadFile(MultipartFile image);
    List<ProductImagesEntity> insertMultiple(MultipartFile[] files, ProductEntity productEntity
    ) throws Exception;

    ProductImagesEntity selectImageById(Long id) throws Exception;

    List<ProductImagesEntity> update(MultipartFile[] files, ProductEntity productEntity) throws Exception;
}
