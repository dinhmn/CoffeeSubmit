package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.SaleOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DinhMN
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO extends BaseDTO {
    
    private String code;
    private BigDecimal total;
    private String seo;
    
    private DeliveryDTO deliveryDTO;
    private List<CustomerDTO> customerDTOList = new ArrayList<>();
    private List<CartProductDTO> cartProductDTOList = new ArrayList<>();

    public static CartDTO from(SaleOrderEntity saleOrderEntity) {
        CartDTO cartDTO = new CartDTO();
        
        cartDTO.setId(saleOrderEntity.getId());
        cartDTO.setCode(saleOrderEntity.getCode());
        cartDTO.setTotal(saleOrderEntity.getTotal());
        cartDTO.setCreatedBy(saleOrderEntity.getCreatedBy());
        cartDTO.setCreatedDate(saleOrderEntity.getCreatedDate());
        cartDTO.setUpdatedBy(saleOrderEntity.getUpdatedBy());
        cartDTO.setUpdatedDate(saleOrderEntity.getUpdatedDate());
        cartDTO.setDeliveryDTO(DeliveryDTO.from(saleOrderEntity.getDeliveryEntity()));
        cartDTO.setCartProductDTOList(saleOrderEntity.getSaleOrderProducts().stream().map(CartProductDTO::from).collect(Collectors.toList()));

        return cartDTO;
    }
}
