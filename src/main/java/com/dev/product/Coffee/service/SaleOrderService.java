package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.OrderEntity;

import java.util.List;

public interface SaleOrderService {
    
    List<OrderEntity> selectAll();
    OrderEntity selectByPrimaryKey(Long id);
    
    OrderEntity insert(OrderEntity orderEntity);
    
    boolean delete(Long id);
    
    OrderEntity update(Long id, OrderEntity orderEntity);
    
}
