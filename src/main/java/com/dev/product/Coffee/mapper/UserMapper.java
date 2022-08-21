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
                user.getRoles()
                        .stream()
                        .map(RoleMapper::toDTO)
                        .collect(Collectors.toList())
        );
        return userDTO;
    }
    
}
