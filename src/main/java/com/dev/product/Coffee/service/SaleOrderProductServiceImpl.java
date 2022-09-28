package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ProductInOrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleOrderProductServiceImpl implements SaleOrderProductService{
    
    
    @Override
    public List<ProductInOrderEntity> selectAll() {
        return null;
    }
    
    @Override
    public ProductInOrderEntity selectByPrimaryKey(Long id) {
        return null;
    }
    
    @Override
    public ProductInOrderEntity insert(ProductInOrderEntity saleOrderEntity) {
        return null;
    }
    
    @Override
    public List<ProductInOrderEntity> insertMultiple(List<ProductInOrderEntity> productInOrderEntityList) {
        return null;
    }
    
    @Override
    public boolean delete(Long id) {
        return false;
    }
    
    @Override
    public ProductInOrderEntity update(Long id, ProductInOrderEntity saleOrderEntity) {
        return null;
    }
}
