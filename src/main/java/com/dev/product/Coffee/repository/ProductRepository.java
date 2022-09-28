package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    
    /* Select * FROM product where price >= min and price <= max; */
    @Query("from products p where p.price>=:min and p.price <=:max ")
    List<ProductEntity> selectByProductByPriceRange(@Param("min") long min,@Param("max") long max);
    
    // Select all product by like title
    @Query("select p from products p where p.title like %:title%")
    List<ProductEntity> selectProductByTitle(@Param("title") String title);
    
    @Query("select p from products p where p.seo =:seo")
    List<ProductEntity> selectProductBySeo(@Param("seo") String seo);
    
    // Select get all product by seo
    @Query("from products p join p.category c where c.seo =:seo")
    List<ProductEntity> selectProductBySeoOfCategory(@Param("seo") String seo);
}
