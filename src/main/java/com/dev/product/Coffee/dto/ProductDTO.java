package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.Response.ResponseData;
import com.dev.product.Coffee.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends BaseDTO{
    private String title;
    private BigDecimal price;
    private BigDecimal priceSale;
    private String shortDescription;
    private String detailsDescription;
    private Long quantity;
    private String seo;
//    private CategoryDTO categoryDTO;
    private List<ImageDTO> imageDTOList = new ArrayList<>();
    public static ProductDTO from(ProductEntity product){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setPrice(product.getPrice());
        productDTO.setPriceSale(product.getPriceSale());
        productDTO.setShortDescription(product.getShortDescription());
        productDTO.setDetailsDescription(product.getDetailsDescription());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setSeo(product.getSeo());
        productDTO.setCreated_date(product.getCreated_date());
        productDTO.setUpdated_by(product.getUpdated_by());
        productDTO.setCreated_by(product.getCreated_by());
        productDTO.setUpdated_date(product.getUpdated_date());
//        productDTO.setCategoryDTO();
        productDTO.setImageDTOList(product.getImageEntity().stream().map(ImageDTO::from).collect(Collectors.toList()));
        return productDTO;
    }

}
