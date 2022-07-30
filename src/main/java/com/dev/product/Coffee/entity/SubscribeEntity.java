package com.dev.product.Coffee.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author DinhMN
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_subscribe")
public class SubscribeEntity extends BaseEntity {
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SubscribeEntity that = (SubscribeEntity) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 1898030244;
    }
}
