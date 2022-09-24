package com.dev.product.Coffee.mapper;


import com.dev.product.Coffee.dto.CartItemsDTO;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.OrderProductsEntity;
import com.dev.product.Coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

/**
 * Switch between DTO <-> Domain model.
 * CartItemDTO <-> SaleOrderProductsEntity
 *
 * @author DinhMN
 */
public class CartItemMapper {
    
    private static CartItemMapper INSTANCE;
    
    @Autowired
    private ProductService productService;
    
    public static CartItemMapper getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new CartItemMapper();
        }
        return INSTANCE;
    }
    
    public OrderProductsEntity toEntity(CartItemsDTO items) {
        OrderProductsEntity productsEntity = new OrderProductsEntity();
        Optional<ProductEntity> product = productService.selectProductById(items.getId());
        productsEntity.setTitle(items.getProductName());
        productsEntity.setPrice(items.getProductPrice());
        productsEntity.setQuantity(items.getQuantity());
        productsEntity.setProductEntity(product.get());
        productsEntity.setCreatedBy(items.getCreatedBy());
        productsEntity.setCreatedDate(items.getCreatedDate());
        productsEntity.setUpdatedBy(items.getUpdatedBy());
        productsEntity.setUpdatedDate(items.getUpdatedDate());
        productsEntity.setStatus(items.getStatus());
        return productsEntity;
    }
    
    public CartItemsDTO toDTO(OrderProductsEntity productsEntity) {
        CartItemsDTO cartItemsDTO = new CartItemsDTO();
        cartItemsDTO.setId(productsEntity.getId());
        cartItemsDTO.setProductName(productsEntity.getTitle());
        cartItemsDTO.setQuantity(productsEntity.getQuantity());
        cartItemsDTO.setProductPrice(productsEntity.getPrice());
        cartItemsDTO.setPathImage(productsEntity.getProductEntity().getImageEntity().get(0).getFileName());
        
        return cartItemsDTO;
    }
}
