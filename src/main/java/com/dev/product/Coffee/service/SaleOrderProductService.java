package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ProductInOrderEntity;

import java.util.List;

public interface SaleOrderProductService {
    
    List<ProductInOrderEntity> selectAll();
    
    ProductInOrderEntity selectByPrimaryKey(Long id);
    
    ProductInOrderEntity insert(ProductInOrderEntity saleOrderEntity);
    List<ProductInOrderEntity> insertMultiple(List<ProductInOrderEntity> productInOrderEntityList);
    
    boolean delete(Long id);
    
    ProductInOrderEntity update(Long id, ProductInOrderEntity saleOrderEntity);
}
