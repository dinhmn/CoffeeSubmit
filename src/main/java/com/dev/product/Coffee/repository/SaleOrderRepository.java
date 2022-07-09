package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.SaleOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrderEntity, Long> {
}
