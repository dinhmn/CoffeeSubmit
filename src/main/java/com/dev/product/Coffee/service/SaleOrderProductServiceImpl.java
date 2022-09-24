package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.OrderProductsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleOrderProductServiceImpl implements SaleOrderProductService{
    
    
    @Override
    public List<OrderProductsEntity> selectAll() {
        return null;
    }
    
    @Override
    public OrderProductsEntity selectByPrimaryKey(Long id) {
        return null;
    }
    
    @Override
    public OrderProductsEntity insert(OrderProductsEntity saleOrderEntity) {
        return null;
    }
    
    @Override
    public List<OrderProductsEntity> insertMultiple(List<OrderProductsEntity> orderProductsEntityList) {
        return null;
    }
    
    @Override
    public boolean delete(Long id) {
        return false;
    }
    
    @Override
    public OrderProductsEntity update(Long id, OrderProductsEntity saleOrderEntity) {
        return null;
    }
}
