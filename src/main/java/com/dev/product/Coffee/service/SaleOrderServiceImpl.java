package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleOrderServiceImpl implements SaleOrderService{
    @Override
    public List<OrderEntity> selectAll() {
        return null;
    }
    
    @Override
    public OrderEntity selectByPrimaryKey(Long id) {
        return null;
    }
    
    @Override
    public OrderEntity insert(OrderEntity orderEntity) {
        return null;
    }
    
    @Override
    public boolean delete(Long id) {
        return false;
    }
    
    @Override
    public OrderEntity update(Long id, OrderEntity orderEntity) {
        return null;
    }
}
