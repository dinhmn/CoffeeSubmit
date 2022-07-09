package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.repository.ImageRepository;
import com.dev.product.Coffee.repository.ProductRepository;
import com.dev.product.Coffee.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.util.StringUtils.cleanPath;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    
    @Autowired
    private final ImageRepository imageRepository;
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public ImageEntity insert(MultipartFile file, ProductEntity productEntity) throws Exception {
        String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence" + fileName);
            }
            ImageEntity imageEntity = new ImageEntity(
                    fileName,
                    file.getContentType(),
                    file.getBytes()
            );
            imageEntity.setProductEntity(productEntity);
            imageEntity.setCreatedDate(new Date());
            return imageRepository.save(imageEntity);
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }
    
    @Override
    public ImageEntity selectImageById(String id) throws Exception {
        return imageRepository.findById(id)
                .orElseThrow(() -> new Exception("File not found with id: " + id));
    }
    
    @Override
    public ImageEntity update(MultipartFile file, ProductEntity productEntity) throws Exception {
        String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        List<ImageEntity> imageEntityList = imageRepository.findAll();
        ImageEntity imageEntity = new ImageEntity();
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence" + fileName);
            }
            for (ImageEntity img : imageEntityList) {
                if (Objects.equals(img.getProductEntity().getId(), productEntity.getId())) {
                    img.setFileName(fileName);
                    img.setFileType(file.getContentType());
                    img.setData(file.getBytes());
                    img.setUpdatedDate(new Date());
                    imageEntity = img;
                }
            }
            return imageRepository.save(imageEntity);
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }
    
    @Override
    public void delete(MultipartFile file, Long productId) throws Exception {
        String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            List<ImageEntity> imageEntityList = imageRepository.findAll();
            Optional<ImageEntity> imageEntity = imageEntityList.stream()
                    .filter(e -> e.getProductEntity().getId().equals(productId))
                    .findFirst();
            imageEntity.ifPresent(imageRepository::delete);
           
        } catch (Exception e) {
            throw new Exception("Could not delete file: " + fileName);
        }
    }
}
