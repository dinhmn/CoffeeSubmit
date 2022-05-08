package com.dev.product.Coffee.entity;

import com.dev.product.Coffee.dto.ImageDTO;
import com.dev.product.Coffee.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<ProductImagesEntity> productImageEntities = new ArrayList<ProductImagesEntity>();

//    public void addProductImage(ProductImagesEntity productImg) {
//        this.productImageEntities.add(productImg);
//        productImg.setProductEntity(this);
//
//    }
//    public void deleteProductImage(ProductImagesEntity productImg) {
//        this.productImageEntities.remove(productImg);
//        productImg.setProductEntity(null);
//    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "productImg")
    private List<ImageEntity> imageEntity = new ArrayList<ImageEntity>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productCmt")
    private List<ReviewsEntity> reviewsEntities = new ArrayList<ReviewsEntity>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<SaleOrderProductsEntity> saleOrderProductsEntities = new ArrayList<>();

    public static ProductEntity from(ProductDTO productDTO){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDTO.getId());
        productEntity.setTitle(productDTO.getTitle());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setPriceSale(productDTO.getPriceSale());
        productEntity.setShortDescription(productDTO.getShortDescription());
        productEntity.setDetailsDescription(productDTO.getDetailsDescription());
        productEntity.setQuantity(productDTO.getQuantity());
        productEntity.setSeo(productDTO.getSeo());
        productEntity.setCreated_date(productDTO.getCreated_date());
        productEntity.setUpdated_by(productDTO.getUpdated_by());
        productEntity.setCreated_by(productDTO.getCreated_by());
        productEntity.setUpdated_date(productDTO.getUpdated_date());
//        productEntity.setCategoriesEntity(CategoriesEntity.from(productDTO.getCategoryDTO()));
        return productEntity;
    }

}
