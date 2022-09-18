package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.CustomerEntity;
import com.dev.product.Coffee.entity.PaymentEntity;
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
public class PaymentDTO extends BaseDTO {
    
    private String payment;
    
    public static PaymentDTO from(PaymentEntity paymentEntity) {
        PaymentDTO paymentDTO = new PaymentDTO();
        BeanUtils.copyProperties(paymentEntity, paymentDTO);
        return paymentDTO;
    }
    
    public static PaymentEntity from(PaymentDTO paymentDTO) {
        PaymentEntity paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(paymentDTO, paymentEntity);
        return paymentEntity;
    }
}
