package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ArticleEntity;

import java.util.List;

public interface PasswordResetService {
    ArticleEntity insert(ArticleEntity articleEntity);
    List<ArticleEntity> selectAll();
    ArticleEntity selectById(Long id);
    boolean delete(Long id);
    ArticleEntity update(Long id, ArticleEntity articleEntity);
    
}
