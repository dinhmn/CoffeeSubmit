package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.RolesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO extends BaseDTO implements Serializable {
    private String name;

}
