package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.ArticleEntity;
import com.dev.product.Coffee.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Override
    public ArticleEntity insert(ArticleEntity articleEntity) {
        articleEntity.setCreatedDate(new Date());
        articleEntity.setStatus(true);
        return articleRepository.save(articleEntity);
    }
    
    @Override
    public List<ArticleEntity> selectAll() {
        return articleRepository.findAll();
    }
    
    @Override
    public ArticleEntity selectById(Long id) {
        return articleRepository.getById(id);
    }
    
    @Override
    public boolean delete(Long id) {
        Optional<ArticleEntity> articleEntityOptional = articleRepository.findById(id);
        if (articleEntityOptional.isPresent()) {
            ArticleEntity articleEntity = articleEntityOptional.get();
            articleRepository.delete(articleEntity);
            return true;
        }
        return false;
    }
    
    @Override
    public ArticleEntity update(Long id, ArticleEntity articleEntity) {
        Optional<ArticleEntity> articleEntityOptional = articleRepository.findById(id);
        if (articleEntityOptional.isPresent()) {
            ArticleEntity updateArticle = articleEntityOptional.get();
            updateArticle.setTitle(articleEntity.getTitle());
            updateArticle.setDescription(articleEntity.getDescription());
            updateArticle.setStatus(articleEntity.getStatus());
            updateArticle.setUpdatedDate(new Date());
            return articleRepository.save(updateArticle);
        }
        return null;
    }
}
