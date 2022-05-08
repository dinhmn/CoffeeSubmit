package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.SaleOrderEntity;
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
public class SaleOrderDTO extends BaseDTO{
    private String code;
    private BigDecimal total;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private String customerMessage;
    private String seo;
    private String delivery;
    private List<SaleOrderProductsDTO> saleOrderProductsDTOList = new ArrayList<SaleOrderProductsDTO>();

    public static SaleOrderDTO from(SaleOrderEntity saleOrderEntity){
        SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
        saleOrderDTO.setId(saleOrderEntity.getId());
        saleOrderDTO.setCode(saleOrderEntity.getCode());
        saleOrderDTO.setTotal(saleOrderEntity.getTotal());
        saleOrderDTO.setCustomerName(saleOrderEntity.getCustomerName());
        saleOrderDTO.setCustomerPhone(saleOrderEntity.getCustomerPhone());
        saleOrderDTO.setCustomerEmail(saleOrderEntity.getCustomerEmail());
        saleOrderDTO.setCustomerAddress(saleOrderEntity.getCustomerAddress());
        saleOrderDTO.setCustomerMessage(saleOrderEntity.getCustomerMessage());
        saleOrderDTO.setSeo(saleOrderEntity.getSeo());
        saleOrderDTO.setDelivery(saleOrderEntity.getDelivery());
        saleOrderDTO.setCreated_by(saleOrderEntity.getCreated_by());
        saleOrderDTO.setCreated_date(saleOrderEntity.getCreated_date());
        saleOrderDTO.setUpdated_by(saleOrderEntity.getUpdated_by());
        saleOrderDTO.setUpdated_date(saleOrderEntity.getUpdated_date());
        saleOrderDTO.setSaleOrderProductsDTOList(saleOrderEntity.getSaleOrderProducts().stream().map(SaleOrderProductsDTO::from).collect(Collectors.toList()));

        return saleOrderDTO;
    }
}
