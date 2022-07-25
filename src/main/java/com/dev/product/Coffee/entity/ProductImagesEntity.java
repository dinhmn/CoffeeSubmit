package com.dev.product.Coffee.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "productImages")
@Table(name = "tbl_product_images")
public class ProductImagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String fileName;
    private String fileType;
    
    @Lob
    private byte[] data;
    
    @Column(name = "created_by", nullable = true)
    private Integer createdBy;
    
    @Column(name = "updated_by", nullable = true)
    private Integer updatedBy;
    
    @Column(name = "created_date", nullable = true)
    private Date createdDate;
    
    @Column(name = "updated_date", nullable = true)
    private Date updatedDate;
    
    public ProductImagesEntity(String fileName, String fileType, byte[] data, Date createdDate, Date updatedDate) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductImagesEntity that = (ProductImagesEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
