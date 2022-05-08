package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity extends BaseEntity{

    private String username;
    private String password;
    private String confirm;
    private String email;
    @Column(name = "enable", nullable = false)
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
    private List<RolesEntity> roles = new ArrayList<RolesEntity>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<ProfileEntity> profile = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<SaleOrderEntity> saleOrder = new ArrayList<>();
}
