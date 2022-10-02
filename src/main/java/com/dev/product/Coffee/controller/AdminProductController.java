package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.dto.ProductDTO;
import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.MultipleImageEntity;
import com.dev.product.Coffee.response.ResponseData;
import com.dev.product.Coffee.service.CategoriesService;
import com.dev.product.Coffee.service.ImageService;
import com.dev.product.Coffee.service.ProductImagesService;
import com.dev.product.Coffee.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.lang.System.out;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin/api")
public class AdminProductController {
    
    @Autowired
    private final ProductService productService;
    @Autowired
    private final CategoriesService categoriesService;
    @Autowired
    private final ProductImagesService productImagesService;
    @Autowired
    private final ImageService imageService;
    
    // Post mapping, user sent request to server
    @PostMapping("/product")
    public ResponseData createProduct(@RequestPart("product") String product,
                                      @RequestParam("file") MultipartFile file,
                                      @RequestParam("files") MultipartFile[] files) throws Exception {
        // pre-variables
        ProductDTO productDTO;
        ObjectMapper objectMapper = new ObjectMapper();
        AtomicReference<List<ImageEntity>> productImage = new AtomicReference<>(Collections.emptyList());
        AtomicReference<List<MultipleImageEntity>> productImagesList = new AtomicReference<>(Collections.emptyList());
        String downloadURI = "";
        try {
            // convert String -> Object
            productDTO = objectMapper.readValue(product, ProductDTO.class);
            
            // get Id from input
            Long id = productDTO.getCategoryId();
            CategoriesEntity categoriesEntity = categoriesService.selectByPrimaryKey(id);
            
            // insert product, file image
            ProductEntity productEntity = productService.insert(ProductEntity.from(productDTO), categoriesEntity);
            productImage.set(Collections.singletonList(imageService.insert(file, productEntity)));
            productImagesList.set(productImagesService.insertMultiple(files, productEntity));
            
            // create downloadURI
            downloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(String.valueOf(productImage.get().get(0).getId()))
                    .toUriString();
        } catch (IOException err) {
            out.println("Error: " + err);
        }
        
        return new ResponseData(productImage.get().get(0).getFileName(),
                downloadURI,
                file.getContentType(),
                file.getSize());
    }
    
    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProductsByPrice(
            @RequestParam(defaultValue = "0", value = "pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
            @RequestParam(defaultValue = "id", value = "sortBy") String sortBy,
            @RequestParam(defaultValue = "true", value = "sort") Boolean sort
    ) {
        List<ProductEntity> productEntityList = Boolean.TRUE.equals(sort) ?
                productService.selectProductByPagingAndSortingWithASC(sortBy, pageNo, pageSize) :
                productService.selectProductByPagingAndSortingWithDESC(sortBy, pageNo, pageSize);
        List<ProductDTO> productDTOList = productEntityList.stream().map(ProductDTO::fromTo).collect(Collectors.toList());
        
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductEntity productEntity = productService.selectProductById(id);
        return new ResponseEntity<>(ProductDTO.from(productEntity), HttpStatus.OK);
    }
    
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable Long id,
                                                        @RequestPart("product") String product,
                                                        @RequestParam("file") MultipartFile file,
                                                        @RequestParam("files") MultipartFile[] files) {
        // pre-variables
        ProductEntity productEntity = null;
        AtomicReference<List<MultipleImageEntity>> productImagesEntity = new AtomicReference<>(Collections.emptyList());
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // convert String -> Object
            ProductDTO productDTO = objectMapper.readValue(product, ProductDTO.class);
            
            productEntity = productService.update(id, ProductEntity.from(productDTO));
            if (!file.isEmpty()) {
                Optional<ImageEntity> imageEntity = imageService.selectAll().stream()
                        .filter(e -> e.getProduct().getId().equals(productDTO.getId()))
                        .findFirst();
                if (imageEntity.isPresent()) {
                    ImageEntity img = imageService.update(file, imageEntity.get(), productEntity);
                    out.println(img);
                } else {
                    imageService.insert(file, productEntity);
                }
            }
            
            productImagesEntity.set(productImagesService.updateByPrimaryKey(files, productEntity));
        } catch (Exception err) {
            out.println("Error: " + err);
        }
        
        assert productEntity != null;
        return new ResponseEntity<>(ProductDTO.from(productEntity), HttpStatus.OK);
    }
    
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProductById(@PathVariable Long id) {
        boolean deleted;
        deleted = productService.deleteProductById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deleted);
        
        return ResponseEntity.ok(response);
    }
    
}
