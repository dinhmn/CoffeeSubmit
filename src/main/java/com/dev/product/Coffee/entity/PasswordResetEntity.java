package com.dev.product.Coffee.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author DinhMN
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_password_reset")
public class PasswordResetEntity extends BaseEntity {
    
    // Password reset
    private String passwordReset;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "users_entity_id", unique = true)
    @ToString.Exclude
    private UsersEntity usersEntity;
    
}
