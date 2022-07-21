package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.SaleOrderProductsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleOrderProductServiceImpl implements SaleOrderProductService{
    
    
    @Override
    public List<SaleOrderProductsEntity> selectAll() {
        return null;
    }
    
    @Override
    public SaleOrderProductsEntity selectByPrimaryKey(Long id) {
        return null;
    }
    
    @Override
    public SaleOrderProductsEntity insert(SaleOrderProductsEntity saleOrderEntity) {
        return null;
    }
    
    @Override
    public List<SaleOrderProductsEntity> insertMultiple(List<SaleOrderProductsEntity> saleOrderProductsEntityList) {
        return null;
    }
    
    @Override
    public boolean delete(Long id) {
        return false;
    }
    
    @Override
    public SaleOrderProductsEntity update(Long id, SaleOrderProductsEntity saleOrderEntity) {
        return null;
    }
}
