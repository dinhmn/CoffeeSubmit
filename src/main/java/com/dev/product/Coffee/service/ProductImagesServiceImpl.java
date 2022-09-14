package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.ProductImagesEntity;
import com.dev.product.Coffee.repository.ProductImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.springframework.util.StringUtils.cleanPath;

@RequiredArgsConstructor
@Service
public class ProductImagesServiceImpl implements ProductImagesService {
    
    @Autowired
    private final ProductImageRepository productImageRepository;
    
    @Override
    public List<ProductImagesEntity> insertMultiple(MultipartFile[] files, Optional<ProductEntity> productEntity)
            throws Exception {
        List<ProductImagesEntity> multipleImage = new ArrayList<>();
        
        for (MultipartFile file : files) {
            String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            try {
                if (fileName.contains("..")) {
                    throw new Exception(String.format("Filename contains invalid path sequence %s", fileName));
                }
                
                ProductImagesEntity productImagesEntity = toProductImagesEntity(fileName, file, productEntity);
                
                multipleImage.add(productImagesEntity);
                productImageRepository.save(productImagesEntity);
            } catch (Exception e) {
                throw new Exception(String.format("Could not save file: %s", file));
            }
        }
        
        return productImageRepository.saveAll(multipleImage);
    }
    
    @Override
    public ProductImagesEntity selectImageById(Long id) throws Exception {
        return productImageRepository.findById(id)
                .orElseThrow(() -> new Exception("File not found with id: " + id));
    }

    @Override
    public List<ProductImagesEntity> updateByPrimaryKey(MultipartFile[] files, ProductEntity productEntity)
            throws Exception {
        List<ProductImagesEntity> beforeProductImagesEntityList = productImageRepository.selectByForeignKey(productEntity.getId());
        List<ProductImagesEntity> actualProductImagesEntityList = new ArrayList<>();
        
        if (beforeProductImagesEntityList.size() == files.length) {
            for (int i = 0; i < files.length; i++) {
                String fileName = cleanPath(Objects.requireNonNull(files[i].getOriginalFilename()));
                try {
                    if (fileName.contains("..")) {
                        throw new Exception("Filename contains invalid path sequence " + fileName);
                    }
                    beforeProductImagesEntityList.get(i).setFileName(fileName);
                    beforeProductImagesEntityList.get(i).setFileType(files[i].getContentType());
                    beforeProductImagesEntityList.get(i).setData(files[i].getBytes());
                    beforeProductImagesEntityList.get(i).setUpdatedDate(new Date());
                    beforeProductImagesEntityList.get(i).setProductEntity(productEntity);
                    actualProductImagesEntityList.add(beforeProductImagesEntityList.get(i));
                    productImageRepository.save(beforeProductImagesEntityList.get(i));
                } catch (Exception e) {
                    throw new Exception("Could not save file: " + files[i]);
                }
            }
        } else {
            productImageRepository.deleteAll(beforeProductImagesEntityList);
            for (MultipartFile file : files) {
                String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                try {
                    if (fileName.contains("..")) {
                        throw new Exception("Filename contains invalid path sequence " + fileName);
                    }
                    ProductImagesEntity productImagesEntity = toProductImagesEntity(fileName, file, productEntity);
                    
                    // add images into list
                    actualProductImagesEntityList.add(productImagesEntity);
                    productImageRepository.save(productImagesEntity);
                } catch (Exception e) {
                    throw new Exception("Could not save file: " + file);
                }
            }
        }
        return actualProductImagesEntityList;
    }
    
    
    /**
     * @param fileName      String
     * @param file          MultipartFile
     * @param productEntity Entity
     * @return ProductImages
     * @throws IOException when data is null or empty
     */
    public ProductImagesEntity toProductImagesEntity(String fileName, MultipartFile file, ProductEntity productEntity) throws IOException {
        return ProductImagesEntity
                .builder()
                .fileName(fileName)
                .fileType(file.getContentType())
                .data(file.getBytes())
                .createdDate(new Date())
                .productEntity(productEntity)
                .build();
    }
    
    public boolean isEmptyUploadFile(MultipartFile[] images) {
        if (images == null || images.length <= 0)
            return true;
        
        return images.length == 1 && Objects.requireNonNull(images[0].getOriginalFilename()).isEmpty();
    }

}
