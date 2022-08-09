package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.SaleOrderProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author DinhMN
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartProductDTO extends BaseDTO{
    
    private String title;
    private Long quantity;
    private BigDecimal price;

    public static CartProductDTO from(SaleOrderProductsEntity saleOrderProductsEntity){
        CartProductDTO cartProductDTO = new CartProductDTO();
        cartProductDTO.setId(saleOrderProductsEntity.getId());
        cartProductDTO.setTitle(saleOrderProductsEntity.getTitle());
        cartProductDTO.setPrice(saleOrderProductsEntity.getPrice());
        cartProductDTO.setQuantity(saleOrderProductsEntity.getQuantity());
        cartProductDTO.setCreatedDate(saleOrderProductsEntity.getCreatedDate());
        cartProductDTO.setCreatedBy(saleOrderProductsEntity.getCreatedBy());
        cartProductDTO.setUpdatedDate(saleOrderProductsEntity.getUpdatedDate());
        cartProductDTO.setUpdatedBy(saleOrderProductsEntity.getUpdatedBy());

        return cartProductDTO;
    }
}
