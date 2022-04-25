package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tbl_products")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity{

    private String title;
    @Column(name = "price", precision = 13, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(name = "price_sale", precision = 13, scale = 2, nullable = true)
    private BigDecimal priceSale;
    private String shortDescription;
    private String detailsDescription;

//    private String fileImage;
//    private String fileName;
//    private String fileType;
//
//    @Lob
//    private byte[] data;
//
//    public ProductEntity(String fileName, String fileType, byte[] data) {
//        this.fileName = fileName;
//        this.fileType = fileType;
//        this.data = data;
//    }

    private Long quantity;
    private String seo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoriesEntity categoriesEntity;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productEntity")
//    private Set<ProductImagesEntity> productImageEntities = new HashSet<ProductImagesEntity>();
//
//    public void addProductImage(ProductImagesEntity productImg) {
//        this.productImageEntities.add(productImg);
//        productImg.setProductEntity(this);
//
//    }
//    public void deleteProductImage(ProductImagesEntity productImg) {
//        this.productImageEntities.remove(productImg);
//        productImg.setProductEntity(null);
//    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private ImageEntity imageEntity;

}
