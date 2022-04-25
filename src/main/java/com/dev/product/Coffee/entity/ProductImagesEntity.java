package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_product_images")
@NoArgsConstructor
@AllArgsConstructor
public class ProductImagesEntity extends BaseEntity{

    private String pathName;
    private String downloadURL;
    private Long size;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id")
//    private ProductEntity productEntity;
}
