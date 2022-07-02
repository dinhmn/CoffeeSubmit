package com.dev.product.Coffee.Dto;

import com.dev.product.Coffee.entity.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private String fileName;
    private String downloadURL;
    private String fileType;
    public static ImageDTO from(ImageEntity imageEntity){
        ImageDTO img = new ImageDTO();
        img.setFileName(imageEntity.getFileName());
        img.setDownloadURL(imageEntity.getId());
        img.setFileType(imageEntity.getFileType());
        return img;
    }
}
