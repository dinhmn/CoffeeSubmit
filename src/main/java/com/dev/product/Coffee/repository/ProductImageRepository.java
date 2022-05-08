package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.ProductImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImagesEntity, String> {
}
