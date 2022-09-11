package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.SaleOrderProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SaleOrderProductRepository extends JpaRepository<SaleOrderProductsEntity, Long> {
    
    List<SaleOrderProductsEntity> selectCartByUserId(@Param("userId") Long userId);

    
}
