package com.dev.product.Coffee.entity;

import com.dev.product.Coffee.dto.SaleOrderProductsDTO;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author DinhMN
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProductInOrderEntity extends BaseEntity {

    private String title;
    private Long quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id", unique = true)
    private ProductEntity product;
    
    public static ProductInOrderEntity from(SaleOrderProductsDTO saleOrderProductsDTO) {
        ProductInOrderEntity saleOrderEntity = new ProductInOrderEntity();
        saleOrderEntity.setId(saleOrderProductsDTO.getId());
        saleOrderEntity.setTitle(saleOrderProductsDTO.getTitle());
        saleOrderEntity.setPrice(saleOrderProductsDTO.getPrice());
        saleOrderEntity.setQuantity(saleOrderProductsDTO.getQuantity());
        saleOrderEntity.setCreatedDate(saleOrderProductsDTO.getCreatedDate());
        saleOrderEntity.setCreatedBy(saleOrderProductsDTO.getCreatedBy());
        saleOrderEntity.setUpdatedDate(saleOrderProductsDTO.getUpdatedDate());
        saleOrderEntity.setUpdatedBy(saleOrderProductsDTO.getUpdatedBy());

        return saleOrderEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductInOrderEntity that = (ProductInOrderEntity) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 945026533;
    }
}
