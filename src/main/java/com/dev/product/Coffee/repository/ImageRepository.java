package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    
    @Query("from image i where i.productEntity.id =:productId")
    Optional<ImageEntity> findByProductId(@Param("productId") Long productId);
    
    @Query("select i.id from image i where 1=1")
    List<String> findByProductIdList();


}
