package com.dev.product.Coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesEntity extends BaseEntity{
    private String name;
    private String desc;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_users_roles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UsersEntity> users = new ArrayList<UsersEntity>();
}
