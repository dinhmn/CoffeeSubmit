package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.SaleOrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleOrderServiceImpl implements SaleOrderService{
    @Override
    public List<SaleOrderEntity> selectAll() {
        return null;
    }
    
    @Override
    public SaleOrderEntity selectByPrimaryKey(Long id) {
        return null;
    }
    
    @Override
    public SaleOrderEntity insert(SaleOrderEntity saleOrderEntity) {
        return null;
    }
    
    @Override
    public boolean delete(Long id) {
        return false;
    }
    
    @Override
    public SaleOrderEntity update(Long id, SaleOrderEntity saleOrderEntity) {
        return null;
    }
}
