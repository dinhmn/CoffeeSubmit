package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends BaseDTO {
    private String title;
    private BigDecimal price;
    private BigDecimal priceSale;
    private String shortDescription;
    private String detailsDescription;
    private Long quantity;
    private String seo;
    private Long categoryId;
    private List<ImageDTO> imageDTOList = new ArrayList<>();
    private List<ProductImagesDTO> productImagesDTOS = new ArrayList<>();
    private List<ReviewsDTO> reviewsDTOS = new ArrayList<>();

    public static ProductDTO from(ProductEntity product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setPrice(product.getPrice());
        productDTO.setPriceSale(product.getPriceSale());
        productDTO.setShortDescription(product.getShortDescription());
        productDTO.setDetailsDescription(product.getDetailsDescription());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setSeo(product.getSeo());
        productDTO.setCreatedDate(product.getCreatedDate());
        productDTO.setUpdatedBy(product.getUpdatedBy());
        productDTO.setCreatedBy(product.getCreatedBy());
        productDTO.setUpdatedDate(product.getUpdatedDate());
        productDTO.setCategoryId(product.getCategoriesEntity().getId());
        productDTO.setImageDTOList(product.getImageEntity().stream().map(ImageDTO::from).collect(Collectors.toList()));
//        productDTO.setImageDTO(ImageDTO.from(product.getImageEntity()));
        productDTO.setProductImagesDTOS(product.getProductImageEntities().stream().map(ProductImagesDTO::from).collect(Collectors.toList()));
        return productDTO;
    }

    public static ProductDTO fromTo(ProductEntity product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setPrice(product.getPrice());
        productDTO.setPriceSale(product.getPriceSale());
        productDTO.setShortDescription(product.getShortDescription());
        productDTO.setDetailsDescription(product.getDetailsDescription());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setSeo(product.getSeo());
        productDTO.setCreatedDate(product.getCreatedDate());
        productDTO.setUpdatedBy(product.getUpdatedBy());
        productDTO.setCreatedBy(product.getCreatedBy());
        productDTO.setUpdatedDate(product.getUpdatedDate());
        productDTO.setImageDTOList(product.getImageEntity().stream().map(ImageDTO::from).collect(Collectors.toList()));
//        productDTO.setImageDTO(ImageDTO.from(product.getImageEntity()));
        productDTO.setProductImagesDTOS(product.getProductImageEntities().stream().map(ProductImagesDTO::from).collect(Collectors.toList()));

        return productDTO;
    }
}
