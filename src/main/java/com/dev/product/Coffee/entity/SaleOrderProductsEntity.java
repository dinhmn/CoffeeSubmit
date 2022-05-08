package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_saleorder_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderProducts extends BaseEntity{

    private String code;
    private BigDecimal total;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private String customerMessage;
    private String seo;
    private String delivery;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UsersEntity user;

}
