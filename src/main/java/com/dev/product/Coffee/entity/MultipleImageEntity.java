package com.dev.product.Coffee.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "productImages")
@Table(name = "tbl_multiple_image")
public class MultipleImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    
    public MultipleImageEntity(String fileName, String fileType, byte[] data, Date createdDate, Date updatedDate) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
