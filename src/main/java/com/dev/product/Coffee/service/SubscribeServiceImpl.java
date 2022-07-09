package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.SubscribeEntity;
import com.dev.product.Coffee.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {
    
    @Autowired
    private final SubscribeRepository subscribeRepository;
    
    @Override
    public SubscribeEntity insert(SubscribeEntity subscribeEntity) {
        subscribeEntity.setCreatedDate(new Date());
        return subscribeRepository.save(subscribeEntity);
    }
    
    @Override
    public List<SubscribeEntity> selectAll() {
        return subscribeRepository.findAll();
    }
}
