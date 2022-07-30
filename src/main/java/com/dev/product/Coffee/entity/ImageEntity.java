package com.dev.product.Coffee.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author DinhMN
 */

@Entity(name = "image")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_product_image")
public class ImageEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Long id;
    
    private String fileName;
    private String fileType;
    
    @Column(name = "created_by", nullable = true)
    private Integer createdBy;
    
    @Column(name = "updated_by", nullable = true)
    private Integer updatedBy;
    
    @Column(name = "created_date", nullable = true)
    private Date createdDate;
    
    @Column(name = "updated_date", nullable = true)
    private Date updatedDate;
    
    @Lob
    @Basic(fetch = FetchType.LAZY, optional = true)
    @ToString.Exclude
    private byte[] data;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
    
    public ImageEntity(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ImageEntity that = (ImageEntity) o;
        return id != null && Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}