package com.dev.product.Coffee.mapper;


import java.util.Objects;

/**
 * Switch between DTO <-> Domain model.
 * CartItemDTO <-> SaleOrderProductsEntity
 *
 * @author DinhMN
 */
public class CartItemMapper {
    
    private static CartItemMapper INSTANCE;
    
    public static CartItemMapper getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new CartItemMapper();
        }
        return INSTANCE;
    }
    
    
}
