package com.dev.product.Coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemsDTO extends BaseDTO{
    
    private Long productId;
    private String productName;
    private Long quantity;
    private BigDecimal price;
    private String categoryName;
    
}
