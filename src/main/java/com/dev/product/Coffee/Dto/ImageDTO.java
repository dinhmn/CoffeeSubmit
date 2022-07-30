package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author DinhMN
 */

@EqualsAndHashCode()
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private String fileName;
    private String downloadURL;
    private String fileType;
    private Integer createdBy;
    private Integer updatedBy;
    private Date createdDate;
    private Date updatedDate;
    
    public static ImageDTO
    from(ImageEntity imageEntity){
        ImageDTO img = new ImageDTO();
        img.setFileName(imageEntity.getFileName());
        img.setDownloadURL(String.valueOf(imageEntity.getId()));
        img.setFileType(imageEntity.getFileType());
        img.setCreatedBy(imageEntity.getCreatedBy());
        img.setUpdatedBy(img.getUpdatedBy());
        img.setCreatedDate(img.getCreatedDate());
        img.setUpdatedDate(img.getUpdatedDate());
        return img;
    }
}
