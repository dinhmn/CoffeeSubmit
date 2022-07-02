package com.dev.product.Coffee.entity;

import com.dev.product.Coffee.Dto.SaleOrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_saleorder")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderEntity extends BaseEntity{
    private String code;
    private BigDecimal total;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private String customerMessage;
    private String seo;
    private String delivery;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UsersEntity user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOrder")
    private List<SaleOrderProductsEntity> saleOrderProducts = new ArrayList<SaleOrderProductsEntity>();

    public static SaleOrderEntity from(SaleOrderDTO saleOrderDTO){
        SaleOrderEntity saleOrderEntity = new SaleOrderEntity();
        saleOrderEntity.setId(saleOrderDTO.getId());
        saleOrderEntity.setCode(saleOrderDTO.getCode());
        saleOrderEntity.setTotal(saleOrderDTO.getTotal());
        saleOrderEntity.setCustomerName(saleOrderDTO.getCustomerName());
        saleOrderEntity.setCustomerPhone(saleOrderDTO.getCustomerPhone());
        saleOrderEntity.setCustomerEmail(saleOrderDTO.getCustomerEmail());
        saleOrderEntity.setCustomerAddress(saleOrderDTO.getCustomerAddress());
        saleOrderEntity.setCustomerMessage(saleOrderDTO.getCustomerMessage());
        saleOrderEntity.setSeo(saleOrderDTO.getSeo());
        saleOrderEntity.setDelivery(saleOrderDTO.getDelivery());
        saleOrderEntity.setCreated_by(saleOrderDTO.getCreated_by());
        saleOrderEntity.setCreated_date(saleOrderDTO.getCreated_date());
        saleOrderEntity.setUpdated_by(saleOrderDTO.getUpdated_by());
        saleOrderEntity.setUpdated_date(saleOrderDTO.getUpdated_date());
//        saleOrderEntity.setSaleOrderProducts(saleOrderDTO.getSaleOrderProductsDTOList().stream().map(SaleOrderProductsDTO::from).collect(Collectors.toList()));

        return saleOrderEntity;
    }
}
