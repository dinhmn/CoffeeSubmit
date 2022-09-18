package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.CustomerEntity;
import com.dev.product.Coffee.entity.DeliveryEntity;
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
public class DeliveryDTO extends BaseDTO{
    
    private String delivery;
    private Boolean status;
    
    public static DeliveryDTO from(DeliveryEntity deliveryEntity) {
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        BeanUtils.copyProperties(deliveryEntity, deliveryDTO);
        return deliveryDTO;
    }
    
    public static DeliveryEntity from(DeliveryDTO deliveryDTO) {
        DeliveryEntity deliveryEntity = new DeliveryEntity();
        BeanUtils.copyProperties(deliveryDTO, deliveryEntity);
        return deliveryEntity;
    }
    
}
