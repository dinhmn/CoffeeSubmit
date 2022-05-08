package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_saleorder")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrder extends BaseEntity{
}
