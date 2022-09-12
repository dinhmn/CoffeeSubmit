package com.dev.product.Coffee.mapper;

import com.dev.product.Coffee.dto.*;
import com.dev.product.Coffee.entity.ProductEntity;
import org.springframework.beans.BeanUtils;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Switch between DTO <-> Domain model.
 * ProductDTO <-> ProductEntity
 *
 * @author DinhMN
 */
public class ProductMapper {
    private static ProductMapper INSTANCE;
    
    public static ProductMapper getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new ProductMapper();
        }
        return INSTANCE;
    }
    
    public ProductEntity toEntity(ProductDTO productDTO) {
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
    
    public ProductDTO toDTOBasic(ProductEntity product) {
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
        productDTO.setCategory(CategoryDTONotProduct.fromToDTO(product.getCategoriesEntity()));
        productDTO.setImages(product.getImageEntity().stream().map(ImageDTO::from).collect(Collectors.toList()));
        productDTO.setImagesList(product.getProductImageEntities().stream().map(ProductImagesDTO::from).collect(Collectors.toList()));
        productDTO.setReviews(product.getReviewsEntityList().stream().map(ReviewsDTO::from).collect(Collectors.toList()));
        return productDTO;
    }
    
    public ProductDTO toDTO(ProductEntity product) {
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
        productDTO.setCategory(CategoryDTONotProduct.fromToDTO(product.getCategoriesEntity()));
        productDTO.setImages(product.getImageEntity().stream().map(ImageDTO::from).collect(Collectors.toList()));
        productDTO.setImagesList(product.getProductImageEntities().stream().map(ProductImagesDTO::from).collect(Collectors.toList()));
        productDTO.setReviews(product.getReviewsEntityList().stream().map(ReviewsDTO::from).collect(Collectors.toList()));
        return productDTO;
    }
}
