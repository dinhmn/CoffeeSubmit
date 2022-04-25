package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/p1")
public class ProductController {

    @Autowired
    private final ProductService productService;



    @PostMapping("/product")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity productEntity,
                                                        @RequestParam("file") MultipartFile productAvatar
                                                        ) throws IOException {
        return ResponseEntity.ok(productService.createProduct(productEntity, productAvatar));
    }
    @GetMapping("/product")
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
