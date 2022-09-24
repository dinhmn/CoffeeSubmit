package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.OrderProductsEntity;

import java.util.List;

public interface SaleOrderProductService {
    
    List<OrderProductsEntity> selectAll();
    
    OrderProductsEntity selectByPrimaryKey(Long id);
    
    OrderProductsEntity insert(OrderProductsEntity saleOrderEntity);
    List<OrderProductsEntity> insertMultiple(List<OrderProductsEntity> orderProductsEntityList);
    
    boolean delete(Long id);
    
    OrderProductsEntity update(Long id, OrderProductsEntity saleOrderEntity);
}
