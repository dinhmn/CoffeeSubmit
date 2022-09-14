package com.dev.product.Coffee.service;

import com.dev.product.Coffee.dto.CartDTO;
import com.dev.product.Coffee.dto.ProductDTO;
import com.dev.product.Coffee.dto.SaleOrderDTO;
import com.dev.product.Coffee.dto.UserDTO;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.SaleOrderEntity;
import com.dev.product.Coffee.entity.SaleOrderProductsEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.exception.AlreadyExistException;
import com.dev.product.Coffee.exception.NotFoundException;
import com.dev.product.Coffee.mapper.ProductMapper;
import com.dev.product.Coffee.mapper.UserMapper;
import com.dev.product.Coffee.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public CartDTO insert(Long userId, Long productId, SaleOrderDTO saleOrderDTO) {
        Optional<UsersEntity> usersEntity = userService.selectByUserId(userId);
        Optional<ProductEntity> productEntity = productService.selectProductById(productId);
        SaleOrderEntity saleOrder = new SaleOrderEntity();
        saleOrder.setUser(usersEntity.get());
        
        return null;
    }
    
    @Override
    public List<CartDTO> find(Long userId) {
        return null;
    }
    
    @Override
    public Optional<CartDTO> find(UserDTO user, ProductDTO product) {
        return null;
    }
    
    @Override
    public CartDTO update(Long userId, CartDTO cartDTO) {
        Optional<UsersEntity> usersEntity = userService.selectByUserId(userId);
        Optional<ProductEntity> productEntity = productService.selectProductById(cartDTO.getProductId());
    
        return null;
    }
    
    @Override
    public void delete(Long userId, Long cartId) {
        Optional<UsersEntity> user = userService.selectByUserId(userId);
        repository.deleteById(cartId);
    }
}

