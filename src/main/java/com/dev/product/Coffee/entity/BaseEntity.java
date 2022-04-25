package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status", nullable = true)
    private Boolean status = Boolean.TRUE;

    @Column(name = "created_by", nullable = true)
    private Integer created_by;

    @Column(name = "updated_by", nullable = true)
    private Integer updated_by;

    @Column(name = "created_date", nullable = true)
    private Date created_date;

    @Column(name = "updated_date", nullable = true)
    private Date updated_date;
}
