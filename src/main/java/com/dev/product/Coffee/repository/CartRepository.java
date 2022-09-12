package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.dto.CartDTO;
import com.dev.product.Coffee.dto.UserDTO;
import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartDTO, Long> {
    
    @Query("FROM SaleOrderEntity so left join SaleOrderProductsEntity sop on so.id = sop.saleOrder.id " +
            "left join PaymentEntity pe on so.id = pe.saleOrder.id " +
            "join CustomerEntity ce on so.id = ce.saleOrderList.id " +
            "left join DeliveryEntity de on so.id = de.saleOrder.id " +
            "join UsersEntity ue on so.id = ue.saleOrder.id " +
            "where so.user.id = :userId " +
            "group by so")
    List<CartDTO> findAllByUserId(@Param("userId") Long userId);
    
    Optional<CartDTO> findByUserAndProduct(UsersEntity user, ProductEntity product);
}
