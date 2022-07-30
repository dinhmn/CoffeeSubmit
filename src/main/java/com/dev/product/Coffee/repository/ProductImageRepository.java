package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.ProductImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImagesEntity, Long> {
    
    @Query("delete from productImages p where p.productEntity.id =:productId")
    void deleteAllByProductEntity(@Param("productId") Long productId);
    
    @Query("select e from products p left join productImages e on p.id = e.productEntity.id where e.productEntity.id =:productId")
    List<ProductImagesEntity> selectByForeignKey(@Param("productId") Long productId);
}
