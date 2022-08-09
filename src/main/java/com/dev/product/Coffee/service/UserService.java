package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;

import java.util.List;

/**
 * @author DinhMN
 */
public interface UserService {
    
    /**
     * @param user UserEntity
     * @return UserEntity
     */
    UsersEntity insert(UsersEntity user);
    
    /**
     * @param role RoleEntity
     * @return RoleEntity
     */
    RolesEntity insert(RolesEntity role);
    
    /**
     * @param userName nameOfUserEntity
     * @param roleName nameOfRoleEntity
     */
    void insertRoleToUser(String userName, String roleName);
    
    /**
     * @param userName nameOfUserEntity
     * @return UserEntity
     */
    UsersEntity selectByUserName(String userName);
    
    /**
     * @return list of user
     */
    List<UsersEntity> selectAll();
}
