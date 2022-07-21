package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.SaleOrderProductsEntity;

import java.util.List;

public interface SaleOrderProductService {
    
    List<SaleOrderProductsEntity> selectAll();
    
    SaleOrderProductsEntity selectByPrimaryKey(Long id);
    
    SaleOrderProductsEntity insert(SaleOrderProductsEntity saleOrderEntity);
    List<SaleOrderProductsEntity> insertMultiple(List<SaleOrderProductsEntity> saleOrderProductsEntityList);
    
    boolean delete(Long id);
    
    SaleOrderProductsEntity update(Long id, SaleOrderProductsEntity saleOrderEntity);
}
