package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.MultipleImageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author DinhMN
 */

@EqualsAndHashCode()
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImagesDTO {

    private String fileName;
    private String fileType;
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private Integer createdBy;
    private Integer updatedBy;
    
    public static ProductImagesDTO from(MultipleImageEntity multipleImageEntity){
        ProductImagesDTO img = new ProductImagesDTO();
        img.setFileName(multipleImageEntity.getFileName());
        img.setId(multipleImageEntity.getId());
        img.setFileType(multipleImageEntity.getFileType());
        img.setCreatedBy(multipleImageEntity.getCreatedBy());
        img.setCreatedDate(multipleImageEntity.getCreatedDate());
        img.setUpdatedDate(multipleImageEntity.getUpdatedDate());
        img.setUpdatedBy(multipleImageEntity.getUpdatedBy());
        return img;
    }
}
