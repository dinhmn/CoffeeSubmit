package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author DinhMN
 */
public interface UserService {
    
    UsersEntity insertUser(UsersEntity user);
    
    RolesEntity insertRole(RolesEntity role);
    
    void insertRoleToUser(String username, String roleName);
    
    Optional<UsersEntity> selectByUsername(String username);
    Optional<UsersEntity> selectByUserId(Long userId);
    
    List<UsersEntity> selectAll();
    
}
