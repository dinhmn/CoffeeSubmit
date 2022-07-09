package com.dev.product.Coffee.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_profile")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProfileEntity extends BaseEntity {

    private String name;
    private String age;
    private String address;
    private String phoneNumber;

    @Lob
    private byte[] data;

    private String birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UsersEntity user;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "users_entity_id", unique = true)
    private UsersEntity usersEntity;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProfileEntity that = (ProfileEntity) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 772697742;
    }
}
