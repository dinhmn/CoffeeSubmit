package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    
    /* Select * FROM product where price >= min and price <= max; */
    @Query("from products p where p.price>=:min and p.price <=:max ")
    List<ProductEntity> selectByProductByPriceRange(@Param("min") long min,@Param("max") long max);
    
    // Select all product by like title
    @Query("select p from products p where p.title like %:title%")
    List<ProductEntity> selectProductByTitle(@Param("title") String title);
    
    // Select get all product by seo
    @Query("select p,c from products p join category c on c.id = p.category_id where c.seo =:seo")
    List<ProductEntity> selectProductBySeoOfCategory(@Param("seo") String seo);
}
