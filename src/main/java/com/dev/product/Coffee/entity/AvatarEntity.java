package com.dev.product.Coffee.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author DinhMN
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_avatar")
public class AvatarEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "users_entity_id", unique = true)
    private UsersEntity usersEntity;
    
    public AvatarEntity(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}
