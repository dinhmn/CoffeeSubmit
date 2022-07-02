package com.dev.product.Coffee.Dto;

import com.dev.product.Coffee.entity.SaleOrderProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
        saleOrderProductsDTO.setCreated_date(saleOrderProductsEntity.getCreated_date());
        saleOrderProductsDTO.setCreated_by(saleOrderProductsEntity.getCreated_by());
        saleOrderProductsDTO.setUpdated_date(saleOrderProductsEntity.getUpdated_date());
        saleOrderProductsDTO.setUpdated_by(saleOrderProductsEntity.getCreated_by());

        return saleOrderProductsDTO;
    }
}
