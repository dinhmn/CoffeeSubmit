package com.dev.product.Coffee.service;

import com.dev.product.Coffee.dto.SaleOrderDTO;
import com.dev.product.Coffee.entity.OrderEntity;

import java.util.List;

public interface SaleOrderService {
    
    List<OrderEntity> selectAll();
    OrderEntity selectByPrimaryKey(Long id);
    
    OrderEntity insert(SaleOrderDTO saleOrder, Long userId);
    
    boolean delete(Long id);
    
    OrderEntity update(Long id, OrderEntity orderEntity);
    
}
