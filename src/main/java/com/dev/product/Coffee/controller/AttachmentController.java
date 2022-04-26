package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.Response.ResponseData;
import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttachmentController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
        String downloadURI = "";
        ImageEntity imageEntity = imageService.saveImage(file);
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
