package com.dev.product.Coffee.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * @author DinhMN
 */

@Entity(name = "image")
@AllArgsConstructor
@Builder
@Data
@Table(name = "tbl_image")
@NoArgsConstructor
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
    private ProductEntity product;
    
    public ImageEntity(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}