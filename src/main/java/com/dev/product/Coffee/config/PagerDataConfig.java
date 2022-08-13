package com.dev.product.Coffee.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PagerDataConfig {
    
    private static int SIZE_OF_PAGE = 10;
    
    // inject entity manager
    @PersistenceContext
    protected EntityManager entityManager;
    
    
}
