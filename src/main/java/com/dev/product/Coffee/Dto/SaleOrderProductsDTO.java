package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.SaleOrderProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderProductsDTO extends BaseDTO{
    private String title;
    private Long quantity;
    private BigDecimal price;

    public static SaleOrderProductsDTO from(SaleOrderProductsEntity saleOrderProductsEntity){
        SaleOrderProductsDTO saleOrderProductsDTO = new SaleOrderProductsDTO();
        saleOrderProductsDTO.setId(saleOrderProductsEntity.getId());
        saleOrderProductsDTO.setTitle(saleOrderProductsEntity.getTitle());
        saleOrderProductsDTO.setPrice(saleOrderProductsEntity.getPrice());
        saleOrderProductsDTO.setQuantity(saleOrderProductsEntity.getQuantity());
        saleOrderProductsDTO.setCreatedDate(saleOrderProductsEntity.getCreatedDate());
        saleOrderProductsDTO.setCreatedBy(saleOrderProductsEntity.getCreatedBy());
        saleOrderProductsDTO.setUpdatedDate(saleOrderProductsEntity.getUpdatedDate());
        saleOrderProductsDTO.setUpdatedBy(saleOrderProductsEntity.getUpdatedBy());

        return saleOrderProductsDTO;
    }
    
    
}
