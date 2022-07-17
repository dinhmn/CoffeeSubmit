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
    
    
    @Sql(SQL_BASE_PATH + "PagingAndSortPrice.sql")
    @DisplayName("Unit test sort by price")
    @Test
    void sort_OK1() {
    
    }
    
}
