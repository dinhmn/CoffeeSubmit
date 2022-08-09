package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.DeliveryEntity;
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
public class DeliveryDTO extends BaseDTO{
    
    private String delivery;
    
    public static DeliveryDTO from(DeliveryEntity delivery) {
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        
        deliveryDTO.setId(deliveryDTO.getId());
        deliveryDTO.setDelivery(deliveryDTO.getDelivery());
        deliveryDTO.setCreatedDate(deliveryDTO.getCreatedDate());
        deliveryDTO.setCreatedBy(deliveryDTO.getCreatedBy());
        deliveryDTO.setUpdatedDate(deliveryDTO.getUpdatedDate());
        deliveryDTO.setUpdatedBy(deliveryDTO.getUpdatedBy());
        
        return deliveryDTO;
    }
}
