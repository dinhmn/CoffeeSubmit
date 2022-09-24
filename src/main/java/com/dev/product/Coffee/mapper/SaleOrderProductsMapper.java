package com.dev.product.Coffee.mapper;

import com.dev.product.Coffee.dto.SaleOrderProductsDTO;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.SaleOrderProductsEntity;
import com.dev.product.Coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

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
    
    public SaleOrderProductsEntity toEntity(SaleOrderProductsDTO items) {
        SaleOrderProductsEntity product = new SaleOrderProductsEntity();
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
    
    public SaleOrderProductsDTO toDTO(SaleOrderProductsEntity saleOrderProductsEntity) {
        SaleOrderProductsDTO productsDTO = new SaleOrderProductsDTO();
        productsDTO.setTitle(saleOrderProductsEntity.getTitle());
        productsDTO.setQuantity(saleOrderProductsEntity.getQuantity());
        productsDTO.setPrice(saleOrderProductsEntity.getPrice());
        productsDTO.setId(saleOrderProductsEntity.getId());
        productsDTO.setCreatedBy(saleOrderProductsEntity.getCreatedBy());
        productsDTO.setCreatedDate(saleOrderProductsEntity.getCreatedDate());
        productsDTO.setUpdatedBy(saleOrderProductsEntity.getUpdatedBy());
        productsDTO.setUpdatedDate(saleOrderProductsEntity.getUpdatedDate());
        productsDTO.setStatus(saleOrderProductsEntity.getStatus());
        
        return productsDTO;
    }
    
}
