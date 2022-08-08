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

    public static SaleOrderDTO from(SaleOrderEntity saleOrderEntity) {
        SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
        saleOrderDTO.setId(saleOrderEntity.getId());
        saleOrderDTO.setCode(saleOrderEntity.getCode());
        saleOrderDTO.setTotal(saleOrderEntity.getTotal());
        saleOrderDTO.setCreatedBy(saleOrderEntity.getCreatedBy());
        saleOrderDTO.setCreatedDate(saleOrderEntity.getCreatedDate());
        saleOrderDTO.setUpdatedBy(saleOrderEntity.getUpdatedBy());
        saleOrderDTO.setUpdatedDate(saleOrderEntity.getUpdatedDate());
        saleOrderDTO.setSaleOrderProductsDTOList(saleOrderEntity.getSaleOrderProducts().stream().map(SaleOrderProductsDTO::from).collect(Collectors.toList()));

        return saleOrderDTO;
    }
}
