package com.dev.product.Coffee.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductSearchModel {
    // tìm theo keyword
    public String keyword;
    
    // tìm theo category
    public Integer categoryId;
    
    public String seo;
    
    public Boolean isHot;
    
    // tìm theo giá
    public BigDecimal price;
    
    public String title;
    
    public Integer quantity;
}
