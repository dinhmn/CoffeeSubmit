package com.dev.product.Coffee.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author DinhMN
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_payment")
public class PaymentEntity extends BaseEntity{
    
    private String formPayment;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_order_id", unique = true)
    private OrderEntity saleOrder;
    
}
