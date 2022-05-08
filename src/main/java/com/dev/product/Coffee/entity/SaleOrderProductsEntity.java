package com.dev.product.Coffee.entity;

import com.dev.product.Coffee.dto.SaleOrderProductsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_saleorder_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderProductsEntity extends BaseEntity{

    private String title;
    private Long quantity;
    private BigDecimal price;
//    private Long size;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "saleOrder_id")
    private SaleOrderEntity saleOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public static SaleOrderProductsEntity from(SaleOrderProductsDTO saleOrderProductsDTO){
        SaleOrderProductsEntity saleOrderEntity = new SaleOrderProductsEntity();
        saleOrderEntity.setId(saleOrderProductsDTO.getId());
        saleOrderEntity.setTitle(saleOrderProductsDTO.getTitle());
        saleOrderEntity.setPrice(saleOrderProductsDTO.getPrice());
        saleOrderEntity.setQuantity(saleOrderProductsDTO.getQuantity());
        saleOrderEntity.setCreated_date(saleOrderProductsDTO.getCreated_date());
        saleOrderEntity.setCreated_by(saleOrderProductsDTO.getCreated_by());
        saleOrderEntity.setUpdated_date(saleOrderProductsDTO.getUpdated_date());
        saleOrderEntity.setUpdated_by(saleOrderProductsDTO.getCreated_by());

        return saleOrderEntity;
    }
}
