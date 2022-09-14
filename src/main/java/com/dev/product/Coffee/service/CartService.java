package com.dev.product.Coffee.service;

import com.dev.product.Coffee.dto.CartDTO;
import com.dev.product.Coffee.dto.ProductDTO;
import com.dev.product.Coffee.dto.SaleOrderDTO;
import com.dev.product.Coffee.dto.UserDTO;
import com.dev.product.Coffee.entity.SaleOrderProductsEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author DinhMN
 */
public interface CartService {
    
    CartDTO insert(Long userId, Long productId,  SaleOrderDTO saleOrderDTO);
    
    List<CartDTO> find(Long userId);
    Optional<CartDTO> find(UserDTO user, ProductDTO product);
    
    CartDTO update(Long userId, CartDTO cartDTO);
    
    void delete(Long userId, Long cartId);
    
    
}
