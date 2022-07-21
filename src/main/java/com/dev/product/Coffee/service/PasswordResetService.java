package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.PasswordResetEntity;

import java.util.List;

public interface PasswordResetService {
    PasswordResetEntity insert(PasswordResetEntity articleEntity);
    List<PasswordResetEntity> selectAll();
    PasswordResetEntity selectByPrimaryKey(Long id);
    boolean delete(Long id);
    PasswordResetEntity update(Long id, PasswordResetEntity articleEntity);
    
}
