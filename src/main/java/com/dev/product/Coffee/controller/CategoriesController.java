package com.dev.product.Coffee.controller;


import com.dev.product.Coffee.dto.CategoryDTO;
import com.dev.product.Coffee.entity.CategoriesEntity;
import com.dev.product.Coffee.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class CategoriesController {

    @Autowired
    private final CategoriesService service;

    @PostMapping("/category")
    public ResponseEntity<CategoriesEntity> createCategory(@RequestBody CategoriesEntity categories) {
        return ResponseEntity.ok(service.insert(categories));
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(
            @RequestParam(defaultValue = "0", value = "pageNo") Integer pageNo,
            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
            @RequestParam(defaultValue = "id", value = "sortBy") String sortBy,
            @RequestParam(defaultValue = "true", value = "sort") Boolean sort
    ) {
        List<CategoriesEntity> categoriesEntities = sort ?
                service.selectCategoryByPagingAndSortingWithASC(sortBy, pageNo, pageSize) :
                service.selectCategoryByPagingAndSortingWithDESC(sortBy, pageNo, pageSize);
        List<CategoryDTO> categoryDTOS = categoriesEntities.stream().map(CategoryDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Long id) {
        boolean deleted = false;
        deleted = service.deleteByPrimaryKey(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deleted);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> getCategoriesById(@PathVariable Long id) {
        CategoriesEntity categories = service.selectByPrimaryKey(id);
        return new ResponseEntity<>(CategoryDTO.from(categories), HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategoriesById(@PathVariable final Long id,
                                                            @RequestBody final CategoryDTO categoryDTO) {
        CategoriesEntity categoriesEntity = service.updateByPrimaryKey(id, CategoriesEntity.from(categoryDTO));
        return new ResponseEntity<>(CategoryDTO.from(categoriesEntity), HttpStatus.OK);
    }

    @PostMapping("/category/{id}/product/{productId}/add")
    public ResponseEntity<CategoryDTO> addProductToCategory(@PathVariable final Long id,
                                                            @PathVariable final Long productId) {
        CategoriesEntity categoriesEntity = service.addProductToCategory(id, productId);
        return new ResponseEntity<>(CategoryDTO.from(categoriesEntity), HttpStatus.OK);
    }

    /**
     * @param id        get id from url
     * @param productId get productId from url
     * @return Status Ok
     */
    @DeleteMapping("/category/{id}/product/{productId}/add")
    public ResponseEntity<CategoryDTO> removeProductToCategory(@PathVariable final Long id,
                                                               @PathVariable final Long productId) {
        CategoriesEntity categoriesEntity = service.addProductToCategory(id, productId);
        return new ResponseEntity<>(CategoryDTO.from(categoriesEntity), HttpStatus.OK);
    }
}
