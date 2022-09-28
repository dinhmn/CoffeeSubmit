package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.MultipleImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultipleImageRepository extends JpaRepository<MultipleImageEntity, Long> {
    
    @Query("delete from productImages p where p.product.id =:productId")
    void deleteAllByProductEntity(@Param("productId") Long productId);
    
    @Query("select e from products p left join productImages e on p.id = e.product.id where e.product.id =:productId")
    List<MultipleImageEntity> selectByForeignKey(@Param("productId") Long productId);
}
