package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author DinhMN
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO implements Serializable {
    private String username;
    private String email;
    private String password;
    private String confirm;
    private Boolean isStatus;
    private Collection<RoleDTO> roleDTOS;
    
}
