package com.dev.product.Coffee.entity;

import com.dev.product.Coffee.dto.SaleOrderDTO;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author DinhMN
 */

@Entity
@Table(name = "tbl_order")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderEntity extends BaseEntity {
    private String code;
    private BigDecimal total;
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity user;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    @ToString.Exclude
    private List<ProductInOrderEntity> productInOrderEntityList = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    @ToString.Exclude
    private DeliveryEntity deliveryEntity;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    @ToString.Exclude
    private PaymentEntity paymentEntity;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", unique = true)
    private CustomerEntity customerEntity;
    
    public static OrderEntity from(SaleOrderDTO saleOrderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(saleOrderDTO.getId());
        orderEntity.setCode(saleOrderDTO.getCode());
        orderEntity.setTotal(saleOrderDTO.getTotal());
        orderEntity.setCreatedBy(saleOrderDTO.getCreatedBy());
        orderEntity.setCreatedDate(saleOrderDTO.getCreatedDate());
        orderEntity.setUpdatedBy(saleOrderDTO.getUpdatedBy());
        orderEntity.setUpdatedDate(saleOrderDTO.getUpdatedDate());

        return orderEntity;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderEntity that = (OrderEntity) o;
        
        return Objects.equals(getId(), that.getId());
    }
    
    @Override
    public int hashCode() {
        return 1069937621;
    }
}
