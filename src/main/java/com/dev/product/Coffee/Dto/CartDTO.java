package com.dev.product.Coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO extends BaseDTO {
    
    private BigDecimal totalPrice = BigDecimal.ZERO;
    
    private List<CartItemsDTO> cartItemList = new ArrayList<>();
    
}
