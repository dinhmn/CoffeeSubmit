package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.ProductImagesEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * @author DinhMN
 */
public interface ProductImagesService {
    
    /**
     * @param files
     * @param productEntity
     * @return
     * @throws Exception
     */
    List<ProductImagesEntity> insertMultiple(MultipartFile[] files, Optional<ProductEntity> productEntity) throws Exception;
    
    /**
     * @param id ImagePK
     * @return Images
     */
    ProductImagesEntity selectImageById(Long id) throws Exception;
    
    /**
     * @param files         is not NUll
     * @param productEntity is not NUll
     * @return list of images of product
     * @throws Exception not fould
     */
    List<ProductImagesEntity> updateByPrimaryKey(MultipartFile[] files, ProductEntity productEntity) throws Exception;
    
}
