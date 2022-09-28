package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.MultipleImageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    List<MultipleImageEntity> insertMultiple(MultipartFile[] files, ProductEntity productEntity) throws Exception;
    
    /**
     * @param id ImagePK
     * @return Images
     */
    MultipleImageEntity selectImageById(Long id) throws Exception;
    
    /**
     * @param files         is not NUll
     * @param productEntity is not NUll
     * @return list of images of product
     * @throws Exception not fould
     */
    List<MultipleImageEntity> updateByPrimaryKey(MultipartFile[] files, ProductEntity productEntity) throws Exception;
    
}
