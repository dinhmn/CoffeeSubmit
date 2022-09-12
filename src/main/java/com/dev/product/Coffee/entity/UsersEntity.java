package com.dev.product.Coffee.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

/**
 * @author DinhMN
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_users")
public class UsersEntity extends BaseEntity {
    
    private String username;
    private String password;
    private String confirm;
    private String email;
    private boolean isEnable;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    @ToString.Exclude
    private Collection<RolesEntity> roles = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usersEntity")
    @ToString.Exclude
    private ProfileEntity profile;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usersEntity")
    @ToString.Exclude
    private AvatarEntity avatarEntity;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    @ToString.Exclude
    private List<SaleOrderEntity> saleOrder = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersEntity")
    @ToString.Exclude
    private List<PasswordResetEntity> passwordReset = new ArrayList<>();
}
