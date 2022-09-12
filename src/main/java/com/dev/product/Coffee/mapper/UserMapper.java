package com.dev.product.Coffee.mapper;

import com.dev.product.Coffee.dto.RoleDTO;
import com.dev.product.Coffee.dto.UserDTO;
import com.dev.product.Coffee.entity.UsersEntity;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Switch between DTO <-> Domain model.
 * UserDTO <-> UserEntity
 *
 * @author DinhMN
 */
public class UserMapper {
    
    private static UserMapper INSTANCE;
    
    public static UserMapper getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new UserMapper();
        }
        return INSTANCE;
    }
    
    public UsersEntity toEntity(UserDTO userDTO) {
        UsersEntity user = new UsersEntity();
        user.setId(userDTO.getId());
        user.setCreatedDate(userDTO.getCreatedDate());
        user.setCreatedBy(userDTO.getCreatedBy());
        user.setStatus(userDTO.getStatus());
        user.setUpdatedDate(userDTO.getUpdatedDate());
        user.setUpdatedBy(userDTO.getUpdatedBy());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setConfirm(userDTO.getConfirm());
        user.setEnable(userDTO.getIsStatus());
        user.setRoles(
                userDTO.getRoleDTOS().stream()
                        .map(RoleMapper::toEntity)
                        .collect(Collectors.toList())
        );
        return user;
    }
    
    public UserDTO toDTO(UsersEntity user) {
        UserDTO userDTO = new UserDTO();
        
        userDTO.setId(user.getId());
        userDTO.setCreatedDate(user.getCreatedDate());
        userDTO.setCreatedBy(user.getCreatedBy());
        userDTO.setStatus(user.getStatus());
        userDTO.setUpdatedDate(user.getUpdatedDate());
        userDTO.setUpdatedBy(user.getUpdatedBy());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setConfirm(user.getConfirm());
        userDTO.setIsStatus(user.getStatus());
        userDTO.setRoleDTOS(
                user.getRoles().stream()
                        .map(RoleMapper::toDTO)
                        .collect(Collectors.toList())
        );
        return userDTO;
    }
    
}
