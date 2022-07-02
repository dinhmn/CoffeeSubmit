package com.dev.product.Coffee.entity;

import com.dev.product.Coffee.dto.SaleOrderDTO;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_saleorder")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    @ToString.Exclude
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SaleOrderEntity that = (SaleOrderEntity) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(code);
    }
}
