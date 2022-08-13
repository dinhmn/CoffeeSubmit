package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;

import java.util.List;

/**
 * @author DinhMN
 */
public interface UserService {
    
    UsersEntity insertUser(UsersEntity user);
    
    RolesEntity insertRole(RolesEntity role);
    
    void insertRoleToUser(String username, String roleName);
    
    UsersEntity selectByUsername(String username);
    
    List<UsersEntity> selectAll();
    
}
