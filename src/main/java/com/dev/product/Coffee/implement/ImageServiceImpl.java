package com.dev.product.Coffee.implement;

import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.repository.ImageRepository;
import com.dev.product.Coffee.repository.ProductRepository;
import com.dev.product.Coffee.service.ImageService;
import com.dev.product.Coffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private final ImageRepository imageRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ImageEntity saveImage(MultipartFile file) throws Exception{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")){
                throw new Exception("Filename contains invalid path sequence"+ fileName) ;
            }
            ImageEntity imageEntity = new ImageEntity(
                    fileName,
                    file.getContentType(),
                    file.getBytes()
            );
            ProductEntity p = productRepository.getById(1L);
            imageEntity.setProductImg(p);
            return imageRepository.save(imageEntity);
        }catch (Exception e){
            throw new Exception("Could not save File: "+ fileName) ;
        }
    }

    @Override
    public ImageEntity getImage(String id) throws Exception {
        return imageRepository.findById(id)
                .orElseThrow(() -> new Exception("File not found with id: " + id));
    }
}
