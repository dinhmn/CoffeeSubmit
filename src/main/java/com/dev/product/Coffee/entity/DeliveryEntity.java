package com.dev.product.Coffee.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author DinhMN
 */

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "tbl_delivery")
public class DeliveryEntity extends BaseEntity {
    
    private String delivery;
    private Boolean status;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", unique = true)
    private OrderEntity order;
    
}
