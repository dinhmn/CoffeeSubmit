package com.dev.product.Coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author DinhMN
 */


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends BaseDTO{
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private String customerMessage;
}
