package com.dev.product.Coffee.service;

import com.dev.product.Coffee.dto.SaleOrderDTO;
import com.dev.product.Coffee.entity.OrderEntity;

/**
 * @author DinhMN
 */
public interface CartService {
    
    OrderEntity insert(Long userId, Long productId, SaleOrderDTO saleOrderDTO);
    
    /*List<CartDTO> find(Long userId);
    Optional<CartDTO> find(UserDTO user, ProductDTO product);
    
    CartDTO update(Long userId, CartDTO cartDTO);*/
    
    void delete(Long userId, Long cartId);
    
    
}
