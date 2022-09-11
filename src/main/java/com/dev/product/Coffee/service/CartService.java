package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.SaleOrderProductsEntity;

import java.util.List;

/**
 * @author DinhMN
 */
public interface CartService {
    
    List<SaleOrderProductsEntity> insert(Long productId, Long userId);
    List<SaleOrderProductsEntity> selectCartByUserId(Long userId);
    List<SaleOrderProductsEntity> deleteCartByUserId(Long cartId, Long userId);
    
    
}
