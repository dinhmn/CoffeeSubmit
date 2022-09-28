package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.MultipleImageEntity;
import com.dev.product.Coffee.repository.MultipleImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.springframework.util.StringUtils.cleanPath;

@RequiredArgsConstructor
@Service
public class ProductImagesServiceImpl implements ProductImagesService {
    
    @Autowired
    private final MultipleImageRepository multipleImageRepository;
    
    @Override
    public List<MultipleImageEntity> insertMultiple(MultipartFile[] files, ProductEntity productEntity)
            throws Exception {
        List<MultipleImageEntity> multipleImage = new ArrayList<>();
        
        for (MultipartFile file : files) {
            String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            try {
                if (fileName.contains("..")) {
                    throw new Exception(String.format("Filename contains invalid path sequence %s", fileName));
                }
                
                MultipleImageEntity multipleImageEntity = toProductImagesEntity(fileName, file, productEntity);
                
                multipleImage.add(multipleImageEntity);
                multipleImageRepository.save(multipleImageEntity);
            } catch (Exception e) {
                throw new Exception(String.format("Could not save file: %s", file));
            }
        }
        
        return multipleImageRepository.saveAll(multipleImage);
    }
    
    @Override
    public MultipleImageEntity selectImageById(Long id) throws Exception {
        return multipleImageRepository.findById(id)
                .orElseThrow(() -> new Exception("File not found with id: " + id));
    }

    @Override
    public List<MultipleImageEntity> updateByPrimaryKey(MultipartFile[] files, ProductEntity productEntity)
            throws Exception {
        List<MultipleImageEntity> beforeMultipleImageEntityList = multipleImageRepository.selectByForeignKey(productEntity.getId());
        List<MultipleImageEntity> actualMultipleImageEntityList = new ArrayList<>();
        
        if (beforeMultipleImageEntityList.size() == files.length) {
            for (int i = 0; i < files.length; i++) {
                String fileName = cleanPath(Objects.requireNonNull(files[i].getOriginalFilename()));
                try {
                    if (fileName.contains("..")) {
                        throw new Exception("Filename contains invalid path sequence " + fileName);
                    }
                    beforeMultipleImageEntityList.get(i).setFileName(fileName);
                    beforeMultipleImageEntityList.get(i).setFileType(files[i].getContentType());
                    beforeMultipleImageEntityList.get(i).setData(files[i].getBytes());
                    beforeMultipleImageEntityList.get(i).setUpdatedDate(new Date());
                    beforeMultipleImageEntityList.get(i).setProduct(productEntity);
                    actualMultipleImageEntityList.add(beforeMultipleImageEntityList.get(i));
                    multipleImageRepository.save(beforeMultipleImageEntityList.get(i));
                } catch (Exception e) {
                    throw new Exception("Could not save file: " + files[i]);
                }
            }
        } else {
            multipleImageRepository.deleteAll(beforeMultipleImageEntityList);
            for (MultipartFile file : files) {
                String fileName = cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                try {
                    if (fileName.contains("..")) {
                        throw new Exception("Filename contains invalid path sequence " + fileName);
                    }
                    MultipleImageEntity multipleImageEntity = toProductImagesEntity(fileName, file, productEntity);
                    
                    // add images into list
                    actualMultipleImageEntityList.add(multipleImageEntity);
                    multipleImageRepository.save(multipleImageEntity);
                } catch (Exception e) {
                    throw new Exception("Could not save file: " + file);
                }
            }
        }
        return actualMultipleImageEntityList;
    }
    
    
    /**
     * @param fileName      String
     * @param file          MultipartFile
     * @param productEntity Entity
     * @return ProductImages
     * @throws IOException when data is null or empty
     */
    public MultipleImageEntity toProductImagesEntity(String fileName, MultipartFile file, ProductEntity productEntity) throws IOException {
        return MultipleImageEntity
                .builder()
                .fileName(fileName)
                .fileType(file.getContentType())
                .data(file.getBytes())
                .createdDate(new Date())
                .product(productEntity)
                .build();
    }
    
    public boolean isEmptyUploadFile(MultipartFile[] images) {
        if (images == null || images.length <= 0)
            return true;
        
        return images.length == 1 && Objects.requireNonNull(images[0].getOriginalFilename()).isEmpty();
    }

}
