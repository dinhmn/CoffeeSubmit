package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderDTO extends BaseDTO {
    private String code;
    private BigDecimal total;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private String customerMessage;
    private String seo;
    private String delivery;
    private List<SaleOrderProductsDTO> saleOrderProductsDTOList = new ArrayList<>();

    public static SaleOrderDTO from(OrderEntity orderEntity) {
        SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
        saleOrderDTO.setId(orderEntity.getId());
        saleOrderDTO.setCode(orderEntity.getCode());
        saleOrderDTO.setTotal(orderEntity.getTotal());
        saleOrderDTO.setCreatedBy(orderEntity.getCreatedBy());
        saleOrderDTO.setCreatedDate(orderEntity.getCreatedDate());
        saleOrderDTO.setUpdatedBy(orderEntity.getUpdatedBy());
        saleOrderDTO.setUpdatedDate(orderEntity.getUpdatedDate());
        saleOrderDTO.setSaleOrderProductsDTOList(orderEntity.getProductInOrderEntityList().stream().map(SaleOrderProductsDTO::from).collect(Collectors.toList()));

        return saleOrderDTO;
    }
}
