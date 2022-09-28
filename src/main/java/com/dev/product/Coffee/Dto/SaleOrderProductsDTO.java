package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.ProductInOrderEntity;
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

    public static SaleOrderProductsDTO from(ProductInOrderEntity productInOrderEntity){
        SaleOrderProductsDTO saleOrderProductsDTO = new SaleOrderProductsDTO();
        saleOrderProductsDTO.setId(productInOrderEntity.getId());
        saleOrderProductsDTO.setTitle(productInOrderEntity.getTitle());
        saleOrderProductsDTO.setPrice(productInOrderEntity.getPrice());
        saleOrderProductsDTO.setQuantity(productInOrderEntity.getQuantity());
        saleOrderProductsDTO.setCreatedDate(productInOrderEntity.getCreatedDate());
        saleOrderProductsDTO.setCreatedBy(productInOrderEntity.getCreatedBy());
        saleOrderProductsDTO.setUpdatedDate(productInOrderEntity.getUpdatedDate());
        saleOrderProductsDTO.setUpdatedBy(productInOrderEntity.getUpdatedBy());

        return saleOrderProductsDTO;
    }
}
