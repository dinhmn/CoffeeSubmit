package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.OrderProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleOrderProductRepository extends JpaRepository<OrderProductsEntity, Long> {
    
//    List<OrderProductsEntity> selectCartByUserId(@Param("userId") Long userId);

    
}
