package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tbl_subcribe")
@NoArgsConstructor
@AllArgsConstructor
public class SubcribeEntity extends BaseEntity{
    private String email;
}
