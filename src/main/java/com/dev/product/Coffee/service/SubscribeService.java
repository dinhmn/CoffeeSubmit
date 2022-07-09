package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.SubscribeEntity;

import java.util.List;

public interface SubscribeService {
    
    SubscribeEntity insert(SubscribeEntity subscribeEntity);
    List<SubscribeEntity> selectAll();
    
}
