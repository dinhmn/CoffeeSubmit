package com.dev.product.Coffee.entity;

import com.dev.product.Coffee.dto.CartDTO;
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
@Table(name = "tbl_saleorder")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SaleOrderEntity extends BaseEntity {
    private String code;
    private BigDecimal total;
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity user;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOrder")
    @ToString.Exclude
    private List<SaleOrderProductsEntity> saleOrderProducts = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "saleOrder")
    @ToString.Exclude
    private DeliveryEntity deliveryEntity;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "saleOrder")
    @ToString.Exclude
    private PaymentEntity paymentEntity;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_entity_id", unique = true)
    private CustomerEntity customerEntity;
    
    public static SaleOrderEntity from(CartDTO cartDTO) {
        SaleOrderEntity saleOrderEntity = new SaleOrderEntity();
        saleOrderEntity.setId(cartDTO.getId());
        saleOrderEntity.setCode(cartDTO.getCode());
        saleOrderEntity.setTotal(cartDTO.getTotal());
        saleOrderEntity.setCreatedBy(cartDTO.getCreatedBy());
        saleOrderEntity.setCreatedDate(cartDTO.getCreatedDate());
        saleOrderEntity.setUpdatedBy(cartDTO.getUpdatedBy());
        saleOrderEntity.setUpdatedDate(cartDTO.getUpdatedDate());

        return saleOrderEntity;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SaleOrderEntity that = (SaleOrderEntity) o;
        
        return Objects.equals(getId(), that.getId());
    }
    
    @Override
    public int hashCode() {
        return 1069937621;
    }
}
