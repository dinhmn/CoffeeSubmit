package com.dev.product.Coffee.mapper;

import com.dev.product.Coffee.dto.SaleOrderProductsDTO;
import com.dev.product.Coffee.entity.OrderProductsEntity;
import com.dev.product.Coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * Switch between DTO <-> Domain model.
 * SaleOrderProductsDTO <-> SaleOrderProductsEntity
 *
 * @author DinhMN
 */
public class SaleOrderProductsMapper {
    
    private static SaleOrderProductsMapper INSTANCE;
    
    @Autowired
    private ProductService productService;
    
    public static SaleOrderProductsMapper getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new SaleOrderProductsMapper();
        }
        return INSTANCE;
    }
    
    public OrderProductsEntity toEntity(SaleOrderProductsDTO items) {
        OrderProductsEntity product = new OrderProductsEntity();
        product.setTitle(items.getTitle());
        product.setPrice(items.getPrice());
        product.setQuantity(items.getQuantity());
        product.setCreatedBy(items.getCreatedBy());
        product.setCreatedDate(items.getCreatedDate());
        product.setUpdatedBy(items.getUpdatedBy());
        product.setUpdatedDate(items.getUpdatedDate());
        product.setStatus(items.getStatus());
        
        return product;
    }
    
    public SaleOrderProductsDTO toDTO(OrderProductsEntity orderProductsEntity) {
        SaleOrderProductsDTO productsDTO = new SaleOrderProductsDTO();
        productsDTO.setTitle(orderProductsEntity.getTitle());
        productsDTO.setQuantity(orderProductsEntity.getQuantity());
        productsDTO.setPrice(orderProductsEntity.getPrice());
        productsDTO.setId(orderProductsEntity.getId());
        productsDTO.setCreatedBy(orderProductsEntity.getCreatedBy());
        productsDTO.setCreatedDate(orderProductsEntity.getCreatedDate());
        productsDTO.setUpdatedBy(orderProductsEntity.getUpdatedBy());
        productsDTO.setUpdatedDate(orderProductsEntity.getUpdatedDate());
        productsDTO.setStatus(orderProductsEntity.getStatus());
        
        return productsDTO;
    }
    
}
