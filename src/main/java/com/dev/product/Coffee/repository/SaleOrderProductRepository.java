package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.SaleOrderProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleOrderProductRepository extends JpaRepository<SaleOrderProductsEntity, Long> {
}
