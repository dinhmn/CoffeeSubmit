package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tbl_contact")
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity extends BaseEntity{


    private String name;
    private String email;
    private String message;

}
