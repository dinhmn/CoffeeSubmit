package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.SaleOrderEntity;

import java.util.List;

public interface SaleOrderService {
    
    List<SaleOrderEntity> selectAll();
    SaleOrderEntity selectByPrimaryKey(Long id);
    
    SaleOrderEntity insert(SaleOrderEntity saleOrderEntity);
    
    boolean delete(Long id);
    
    SaleOrderEntity update(Long id, SaleOrderEntity saleOrderEntity);
    
}
