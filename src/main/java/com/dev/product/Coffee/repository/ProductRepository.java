package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    
    // Select * FROM product where price >= min and price <= max;
    @Query("from products p where p.price>=:min and p.price <=:max ")
    List<ProductEntity> selectByProductByPriceRange(BigDecimal min, BigDecimal max);
}
