package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.Response.ResponseData;
import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.ProductImagesEntity;
import com.dev.product.Coffee.service.ImageService;
import com.dev.product.Coffee.service.ProductImagesService;
import com.dev.product.Coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@CrossOrigin("*")
@RestController
public class AttachmentController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ProductImagesService productImagesService;

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file,
                                   @RequestParam("files") MultipartFile[] files,
                                   @RequestParam("id") Long id
    ) throws Exception {
        String downloadURI = "";
        ProductEntity product = productService.getProductById(id);
        ImageEntity imageEntity = imageService.saveImage(file, product);
        List<ProductImagesEntity> productImagesEntity = productImagesService.saveImage(files, product);
        downloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(imageEntity.getId())
                .toUriString();


        return new ResponseData(imageEntity.getFileName(),
                downloadURI,
                file.getContentType(),
                file.getSize());
    }
    @PutMapping("/upload/{id}")
    public ResponseData updateUploadFile(@RequestParam("file") MultipartFile file,
                                         @RequestParam("files") MultipartFile[] files,
                                         @PathVariable Long id) throws Exception {
        String downloadURI = "";
        ProductEntity productEntity = productService.getProductById(id);
        ImageEntity imageEntity = imageService.updateImage(file, productEntity);
        List<ProductImagesEntity> productImagesEntity = productImagesService.updateImage(files, productEntity);
        downloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(imageEntity.getId())
                .toUriString();


        return new ResponseData(imageEntity.getFileName(),
                downloadURI,
                file.getContentType(),
                file.getSize());
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String id) throws Exception {
        ImageEntity imageEntity = imageService.getImage(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "Image: fileName=\"" + imageEntity.getFileName() + "\"")
                .body(new ByteArrayResource(imageEntity.getData()));
    }
}
