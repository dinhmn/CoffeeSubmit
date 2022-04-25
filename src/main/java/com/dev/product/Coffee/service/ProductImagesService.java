package com.dev.product.Coffee.service;

import org.springframework.web.multipart.MultipartFile;

public interface ProductImagesService {

    public boolean isEmptyUploadFile(MultipartFile[] images);
    public boolean isEmptyUploadFile(MultipartFile image);
}
