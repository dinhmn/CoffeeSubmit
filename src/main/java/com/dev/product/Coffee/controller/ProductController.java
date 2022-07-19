package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.response.ResponseData;
import com.dev.product.Coffee.dto.ProductDTO;
import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.entity.ImageEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.ProductImagesEntity;
import com.dev.product.Coffee.service.CategoriesService;
import com.dev.product.Coffee.service.ImageService;
import com.dev.product.Coffee.service.ProductImagesService;
import com.dev.product.Coffee.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.lang.System.*;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/p1")
public class ProductController {
    
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
        ImageEntity imageEntity = null;
        AtomicReference<List<ProductImagesEntity>> productImagesEntity = new AtomicReference<>(Collections.emptyList());
        String downloadURI = "";
        try {
            // convert String -> Object
            productDTO = objectMapper.readValue(product, ProductDTO.class);
            
            // get Id from input
            Long id = productDTO.getCategoryId();
            CategoriesEntity categoriesEntity = categoriesService.getCategories(id);
            
            // insert product, file image
            ProductEntity productEntity = productService.insert(ProductEntity.from(productDTO), file, categoriesEntity);
            imageEntity = imageService.insert(file, productEntity);
            productImagesEntity.set(productImagesService.insertMultiple(files, productEntity));
            
            // create downloadURI
            downloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(imageEntity.getId())
                    .toUriString();
        } catch (IOException err) {
            out.println("Error: " + err.toString());
        }
        
        assert imageEntity != null;
        return new ResponseData(imageEntity.getFileName(),
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
        List<ProductEntity> productEntityList = sort ?
                productService.selectProductByPagingAndSortingWithASC(sortBy, pageNo, pageSize) :
                productService.selectProductByPagingAndSortingWithDESC(sortBy, pageNo, pageSize);
        List<ProductDTO> productDTOList = productEntityList.stream().map(ProductDTO::fromTo).collect(Collectors.toList());
        
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }
    
    @GetMapping("/product/search")
    public ResponseEntity<List<ProductDTO>> getAllProductsByTitle(@RequestParam(value = "title") String title) {
        List<ProductEntity> productEntityList = productService.selectProdcutByTitle(title, Sort.by("price"));
        List<ProductDTO> productDTOList = productEntityList.stream().map(ProductDTO::fromTo).collect(Collectors.toList());
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }
    @GetMapping("/product/{seo}")
    public ResponseEntity<List<ProductDTO>> getAllProductsBySeoOfCategory(@PathVariable String seo) {
        List<ProductEntity> productEntityList = productService.selectProductBySeoOfCategory(seo);
        List<ProductDTO> productDTOList = productEntityList.stream().map(ProductDTO::fromTo).collect(Collectors.toList());
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }
    
    @GetMapping("/product/min={min}&max={max}")
    public ResponseEntity<List<ProductDTO>> getAllProductsByPriceMinMax(@RequestParam(value = "min") String min, @RequestParam(value = "max") String max) {
        List<ProductEntity> productEntityList = productService.selectProdcutByPriceRange(Long.parseLong(min), Long.parseLong(max));
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
        AtomicReference<List<ProductImagesEntity>> productImagesEntity = new AtomicReference<>(Collections.emptyList());
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // convert String -> Object
            ProductDTO productDTO = objectMapper.readValue(product, ProductDTO.class);
            
            productEntity = productService.update(id, ProductEntity.from(productDTO));
            if (!file.isEmpty()) {
                imageService.delete(file, productEntity.getId());
                imageService.update(file, productEntity);
            }
            
            productImagesEntity.set(productImagesService.update(files, productEntity));
        } catch (Exception err) {
            out.println("Error: " + err.toString());
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
