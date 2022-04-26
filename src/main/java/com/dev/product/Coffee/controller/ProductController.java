package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.dto.ProductDTO;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/p1")
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO,
                                                        @RequestParam("file") MultipartFile productAvatar
                                                        ) throws Exception {
        ProductEntity productEntity = productService.createProduct(ProductEntity.from(productDTO), productAvatar);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductEntity> productEntities = productService.getAllProducts();
        List<ProductDTO> productDTOList = productEntities.stream().map(ProductDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductEntity productEntity = productService.getProductById(id);
        return new ResponseEntity<>(ProductDTO.from(productEntity), HttpStatus.OK);
    }
//    @PutMapping("/product/{id}")

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProductById(@PathVariable Long id){
        boolean deleted = false;
        deleted = productService.deleteProduct(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deleted);

        return ResponseEntity.ok(response);
    }
}
