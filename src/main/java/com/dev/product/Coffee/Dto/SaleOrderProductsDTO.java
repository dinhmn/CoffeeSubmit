package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.OrderProductsEntity;
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

    public static SaleOrderProductsDTO from(OrderProductsEntity orderProductsEntity){
        SaleOrderProductsDTO saleOrderProductsDTO = new SaleOrderProductsDTO();
        saleOrderProductsDTO.setId(orderProductsEntity.getId());
        saleOrderProductsDTO.setTitle(orderProductsEntity.getTitle());
        saleOrderProductsDTO.setPrice(orderProductsEntity.getPrice());
        saleOrderProductsDTO.setQuantity(orderProductsEntity.getQuantity());
        saleOrderProductsDTO.setCreatedDate(orderProductsEntity.getCreatedDate());
        saleOrderProductsDTO.setCreatedBy(orderProductsEntity.getCreatedBy());
        saleOrderProductsDTO.setUpdatedDate(orderProductsEntity.getUpdatedDate());
        saleOrderProductsDTO.setUpdatedBy(orderProductsEntity.getUpdatedBy());

        return saleOrderProductsDTO;
    }
    
    
}
