package com.dev.product.Coffee.implement;

import com.dev.product.Coffee.service.ProductImagesService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductImagesServiceImpl implements ProductImagesService {

    public boolean isEmptyUploadFile(MultipartFile[] images) {
        if (images == null || images.length <= 0)
            return true;

        if (images.length == 1 && images[0].getOriginalFilename().isEmpty())
            return true;

        return false;
    }

    public boolean isEmptyUploadFile(MultipartFile image) {
        return image == null || image.getOriginalFilename().isEmpty();
    }
}
