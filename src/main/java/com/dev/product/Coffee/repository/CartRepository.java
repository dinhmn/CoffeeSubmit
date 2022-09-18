package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.SaleOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<SaleOrderEntity, Long> {
    
/*    @Query("FROM SaleOrderEntity so left join SaleOrderProductsEntity sop on so.id = sop.saleOrder.id " +
            "left join PaymentEntity pe on so.id = pe.saleOrder.id " +
            "join CustomerEntity ce on so.id = ce.saleOrderList.id " +
            "left join DeliveryEntity de on so.id = de.saleOrder.id " +
            "join UsersEntity ue on so.id = ue.saleOrder.id " +
            "where so.user.id = :userId " +
            "group by so")
    List<CartDTO> findAllByUserId(@Param("userId") Long userId);
    
    Optional<CartDTO> findByUserAndProduct(UsersEntity user, ProductEntity product);*/
    
    
}
