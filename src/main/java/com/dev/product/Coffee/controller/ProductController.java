package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.dto.ProductDTO;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/p1")
public class ProductController {
    
    @Autowired
    private final ProductService productService;
    
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
    
    /**
     * @param min   price is min
     * @param max   price is max
     * @return list product dto
     */
    @GetMapping("/product/min={min}&max={max}")
    public ResponseEntity<List<ProductDTO>> getAllProductsByPriceMinMax(@PathVariable String max, @PathVariable String min) {
        List<ProductEntity> productEntityList = productService.selectProdcutByPriceRange(Long.parseLong(min), Long.parseLong(max));
        List<ProductDTO> productDTOList = productEntityList.stream().map(ProductDTO::fromTo).collect(Collectors.toList());
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }
}
