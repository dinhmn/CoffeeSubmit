package com.dev.product.Coffee.service;

import com.dev.product.Coffee.dto.ProductDTO;
import com.dev.product.Coffee.dto.SaleOrderDTO;
import com.dev.product.Coffee.dto.UserDTO;
import com.dev.product.Coffee.entity.CustomerEntity;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.SaleOrderEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author DinhMN
 */
@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartRepository repository;
    
    @Override
    public SaleOrderEntity insert(Long userId, Long productId, SaleOrderDTO saleOrderDTO) {
        Optional<UsersEntity> usersEntity = userService.selectByUserId(userId);
        Optional<ProductEntity> productEntity = productService.selectProductById(productId);
        CustomerEntity customerEntity = new CustomerEntity();
        SaleOrderEntity saleOrder = new SaleOrderEntity();
        if (usersEntity.isPresent()) {
            saleOrder.setUser(usersEntity.get());
            
        }
        return null;
    }
    
 
    @Override
    public void delete(Long userId, Long cartId) {
        Optional<UsersEntity> user = userService.selectByUserId(userId);
        repository.deleteById(cartId);
    }
}

