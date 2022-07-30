package com.dev.product.Coffee.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DinhMN
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_customer")
public class CustomerEntity extends BaseEntity {
    
    private String name;
    private String email;
    private String age;
    private String address;
    private String phone;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerEntity")
    @ToString.Exclude
    private List<SaleOrderEntity> saleOrderEntity = new ArrayList<>();
    
}
