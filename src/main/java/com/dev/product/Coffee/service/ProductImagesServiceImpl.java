package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.ProductImagesEntity;
import com.dev.product.Coffee.repository.ProductImageRepository;
import com.dev.product.Coffee.repository.ProductRepository;
import com.dev.product.Coffee.service.ProductImagesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.springframework.util.StringUtils.cleanPath;

@AllArgsConstructor
@Service
public class ProductImagesServiceImpl implements ProductImagesService {
    
    @Autowired
    private final ProductImageRepository productImageRepository;
    
    public boolean isEmptyUploadFile(MultipartFile[] images) {
        if (images == null || images.length <= 0)
            return true;
        
        return images.length == 1 && Objects.requireNonNull(images[0].getOriginalFilename()).isEmpty();
    }
    
    public boolean isEmptyUploadFile(MultipartFile image) {
        return !(image != null && !Objects.requireNonNull(image.getOriginalFilename()).isEmpty());
    }
    
    @Override
    public List<ProductImagesEntity> insertMultiple(MultipartFile[] files, ProductEntity productEntity) throws Exception {
        List<ProductImagesEntity> multipleImage = new ArrayList<>();
        for (MultipartFile file :
                files) {
            String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            try {
                if (fileName.contains("..")) {
                    throw new Exception(String.format("Filename contains invalid path sequence %s", fileName));
                }
                ProductImagesEntity productImagesEntity = new ProductImagesEntity(
                        fileName,
                        file.getContentType(),
                        file.getBytes(),
                        new Date(),
                        null
                );
                productImagesEntity.setCreatedDate(new Date());
                productImagesEntity.setProductEntity(productEntity);
                multipleImage.add(productImagesEntity);
                productImageRepository.save(productImagesEntity);
            } catch (Exception e) {
                throw new Exception(String.format("Could not save file: %s", file));
            }
        }
        
        return productImageRepository.saveAll(multipleImage);
    }
    
    
    @Override
    public ProductImagesEntity selectImageById(String id) throws Exception {
        return productImageRepository.findById(id)
                .orElseThrow(() -> new Exception("File not found with id: " + id));
    }
    
    /**
     * @param files         is not NUll
     * @param productEntity is not NUll
     * @return list product images
     * @throws Exception not fould
     */
    @Override
    public List<ProductImagesEntity> update(MultipartFile[] files, ProductEntity productEntity) throws Exception {
        List<ProductImagesEntity> pr = new ArrayList<>();
        List<ProductImagesEntity> productImagesEntityList = new ArrayList<>();
        List<ProductImagesEntity> getAllProductImagesEntity = productImageRepository.findAll();
        getAllProductImagesEntity.forEach(p -> {
            if (p.getProductEntity().getId().equals(productEntity.getId())) {
                productImagesEntityList.add(p);
            }
        });
        if (productImagesEntityList.size() == files.length) {
            for (int i = 0; i < files.length; i++) {
                String fileName = cleanPath(Objects.requireNonNull(files[i].getOriginalFilename()));
                try {
                    if (fileName.contains("..")) {
                        throw new Exception("Filename contains invalid path sequence " + fileName);
                    }
                    productImagesEntityList.get(i).setFileName(fileName);
                    productImagesEntityList.get(i).setFileType(files[i].getContentType());
                    productImagesEntityList.get(i).setData(files[i].getBytes());
                    productImagesEntityList.get(i).setUpdatedDate(new Date());
                    pr.add(productImagesEntityList.get(i));
                    productImageRepository.save(productImagesEntityList.get(i));
                } catch (Exception e) {
                    throw new Exception("Could not save file: " + files[i]);
                }
            }
        } else {
            getAllProductImagesEntity.forEach(p -> {
                if (p.getProductEntity().getId().equals(productEntity.getId())) {
                    productImageRepository.delete(p);
                }
            });
            for (MultipartFile file :
                    files) {
                String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                try {
                    if (fileName.contains("..")) {
                        throw new Exception("Filename contains invalid path sequence " + fileName);
                    }
                    ProductImagesEntity productImagesEntity = new ProductImagesEntity(
                            fileName,
                            file.getContentType(),
                            file.getBytes(),
                            new Date(),
                            null
                    );
                    productImagesEntity.setProductEntity(productEntity);
                    pr.add(productImagesEntity);
                    productImageRepository.save(productImagesEntity);
                } catch (Exception e) {
                    throw new Exception("Could not save file: " + file);
                }
            }
        }
        return productImageRepository.saveAll(pr);
    }
    
}