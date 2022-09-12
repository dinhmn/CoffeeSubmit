package com.dev.product.Coffee.mapper;

import com.dev.product.Coffee.dto.RoleDTO;
import com.dev.product.Coffee.dto.UserDTO;
import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Switch between DTO <-> Domain model.
 * RoleDTO <-> RolesEntity
 *
 * @author DinhMN
 */
public class RoleMapper {
    
    private static RoleMapper INSTANCE;
    
    public static RoleMapper getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new RoleMapper();
        }
        return INSTANCE;
    }
    
    public static RolesEntity toEntity(RoleDTO roleDTO) {
        RolesEntity role = new RolesEntity();
        role.setId(roleDTO.getId());
        role.setCreatedDate(roleDTO.getCreatedDate());
        role.setCreatedBy(roleDTO.getCreatedBy());
        role.setStatus(roleDTO.getStatus());
        role.setUpdatedDate(roleDTO.getUpdatedDate());
        role.setUpdatedBy(roleDTO.getUpdatedBy());
        role.setName(roleDTO.getName());
        return role;
    }
    
    public static RoleDTO toDTO(RolesEntity role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setCreatedDate(role.getCreatedDate());
        roleDTO.setCreatedBy(role.getCreatedBy());
        roleDTO.setStatus(role.getStatus());
        roleDTO.setUpdatedDate(role.getUpdatedDate());
        roleDTO.setUpdatedBy(role.getUpdatedBy());
        roleDTO.setName(role.getName());
        return roleDTO;
    }
    
}
