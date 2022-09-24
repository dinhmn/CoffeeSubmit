package com.dev.product.Coffee.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author DinhMN
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_delivery")
public class DeliveryEntity extends BaseEntity {
    
    private String delivery;
    private Boolean isActive;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_order_id", unique = true)
    private OrderEntity saleOrder;
    
}
