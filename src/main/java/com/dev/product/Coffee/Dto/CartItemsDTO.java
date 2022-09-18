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
    
    private Long id;
    private String productName;
    private BigDecimal productPrice;
    private String pathImage;
    private Long quantity;
    
}
