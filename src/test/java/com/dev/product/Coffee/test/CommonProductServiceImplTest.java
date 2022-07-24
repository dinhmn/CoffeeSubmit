package com.dev.product.Coffee.test;

import com.dev.product.Coffee.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommonProductServiceImplTest {
    
    private static final String SQL_BASE_PATH = "./src/main/resources/postgresql/CommonProductProductImplTest/";
    
    @Autowired
    private ProductService productService;
    
    
    @DisplayName("Unit test sort by price")
    @Test
    void sort_OK1() {
    
    }
    
    @Test
    void insert() {
    }
    
    @Test
    void testInsert() {
    }
    
    @Test
    void selectAll() {
    }
    
    @Test
    void selectProductById() {
    }
    
    @Test
    void selectProdcutByPriceRange() {
    }
    
    @Test
    void selectProdcutByTitle() {
    }
    
    @Test
    void selectProductBySeoOfCategory() {
    }
    
    @Test
    void selectProductByPagingAndSortingWithASC() {
    }
    
    @Test
    void selectProductByPagingAndSortingWithDESC() {
    }
    
    @Test
    void search() {
    }
    
    @Test
    void deleteProductById() {
    }
    
    @Test
    void update() {
    }
}
