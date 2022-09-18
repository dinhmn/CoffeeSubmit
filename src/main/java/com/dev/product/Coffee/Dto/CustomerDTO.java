package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @author DinhMN
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends BaseDTO {
    
    private String customerName;
    private String customerEmail;
    private String customerAge;
    private String customerAddress;
    private String customerPhone;
    
    public static CustomerDTO from(CustomerEntity customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }
    
    public static CustomerEntity from(CustomerDTO customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        return customerEntity;
    }
    
}
