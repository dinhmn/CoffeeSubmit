package com.dev.product.Coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author DinhMN
 */

@EqualsAndHashCode()
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{
  private String username;
  private String password;
  private String confirm;
  private String email;
}
