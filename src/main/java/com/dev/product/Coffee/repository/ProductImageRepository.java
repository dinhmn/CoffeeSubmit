package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.ProductImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImagesEntity, String> {
    
    @Query("delete from productImages p where p.productEntity.id =:productId")
    void deleteAllByProductEntity(@Param("productId") Long productId);
    
}
