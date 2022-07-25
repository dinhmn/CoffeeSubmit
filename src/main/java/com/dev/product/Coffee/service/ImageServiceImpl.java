package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.util.StringUtils.cleanPath;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    
    @Autowired
    private final ImageRepository repository;
    
    @Override
    @Transactional
    public ImageEntity insert(MultipartFile file, ProductEntity productEntity) throws Exception {
        System.out.println(file);
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
            
            return repository.save(imageEntity);
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }
    
    @Override
    public List<ImageEntity> selectAll() {
        return repository.findAll();
    }
    
    @Override
    public ImageEntity selectImageById(String id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("File not found with id: " + id));
    }
    
    @Override
    public ImageEntity update(MultipartFile file, ImageEntity imageEntity, Long productId) throws Exception {
        String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        List<ImageEntity> imageEntityList = repository.findAll();
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence" + fileName);
            }
            Optional<ImageEntity> imageEntityInput = imageEntityList.stream().filter(e -> e.getProductEntity().getId().equals(productId))
                    .map(image -> toImageEntity(imageEntity, fileName, file))
                    .findFirst();
            return repository.save(imageEntityInput.get());
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }
    
    @Override
    public void delete(MultipartFile file, Long productId) throws Exception {
        String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            List<ImageEntity> imageEntityList = repository.findAll();
            Optional<ImageEntity> imageEntity = imageEntityList.stream()
                    .filter(e -> e.getProductEntity().getId().equals(productId))
                    .findFirst();
            imageEntity.ifPresent(repository::delete);
            
        } catch (Exception e) {
            throw new Exception("Could not delete file: " + fileName);
        }
    }
    
    private ImageEntity toImageEntity(ImageEntity imageEntity, String fileName, MultipartFile file) {
        try {
            ImageEntity image = repository.getById(imageEntity.getId());
            image.setFileName(fileName);
            image.setFileType(file.getContentType());
            image.setData(file.getBytes());
            image.setUpdatedDate(new Date());
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
