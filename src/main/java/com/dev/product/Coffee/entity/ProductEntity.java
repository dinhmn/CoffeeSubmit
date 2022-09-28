package com.dev.product.Coffee.entity;

import com.dev.product.Coffee.dto.ProductDTO;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author DinhMN
 */

@Entity(name = "products")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_products")
public class ProductEntity extends BaseEntity {
    
    private String title;
    @Column(name = "price", precision = 13, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(name = "price_sale", precision = 13, scale = 2, nullable = true)
    private BigDecimal priceSale;
    private String shortDescription;
    private String detailsDescription;
    
    private Long quantity;
    private String seo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoriesEntity category;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    @ToString.Exclude
    private List<MultipleImageEntity> productImageEntities = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    @ToString.Exclude
    private List<ImageEntity> imageEntity = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    @ToString.Exclude
    private List<ReviewsEntity> reviewsEntityList = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    @ToString.Exclude
    private ProductInOrderEntity productInOrder;
    
    public static ProductEntity from(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDTO.getId());
        productEntity.setTitle(productDTO.getTitle());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setPriceSale(productDTO.getPriceSale());
        productEntity.setShortDescription(productDTO.getShortDescription());
        productEntity.setDetailsDescription(productDTO.getDetailsDescription());
        productEntity.setQuantity(productDTO.getQuantity());
        productEntity.setSeo(productDTO.getSeo());
        productEntity.setCreatedDate(productDTO.getCreatedDate());
        productEntity.setUpdatedBy(productDTO.getUpdatedBy());
        productEntity.setCreatedBy(productDTO.getCreatedBy());
        productEntity.setUpdatedDate(productDTO.getUpdatedDate());
//        productEntity.setImageEntity(ImageEntity.from(productDTO.getImageDTO()));
        return productEntity;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity that = (ProductEntity) o;
        
        return Objects.equals(getId(), that.getId());
    }
    
    @Override
    public int hashCode() {
        return 335418294;
    }
}
