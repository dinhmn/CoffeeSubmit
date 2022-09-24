package com.dev.product.Coffee.dto;

import com.dev.product.Coffee.entity.OrderEntity;
import com.dev.product.Coffee.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DinhMN
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderDTO extends BaseDTO {
    private String code;
    private Boolean isStatus;
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private List<CartItemsDTO> cartItemsDTOList;
    private UserDTO userDTO;
    private DeliveryDTO deliveryDTO;
    private CustomerDTO customerDTO;
    private PaymentDTO paymentDTO;
    private List<SaleOrderProductsDTO> saleOrderProductsDTOList = new ArrayList<>();
    
    public static SaleOrderDTO from(OrderEntity orderEntity) {
        SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
        saleOrderDTO.setTotalPrice(orderEntity.getTotal());
        saleOrderDTO.setCode(orderEntity.getCode());
        saleOrderDTO.setIsStatus(orderEntity.getIsStatus());
        saleOrderDTO.setUserDTO(UserMapper.getInstance().toDTO(orderEntity.getUser()));
        
        saleOrderDTO.setSaleOrderProductsDTOList(orderEntity.getOrderProducts().stream().map(SaleOrderProductsDTO::from).collect(Collectors.toList()));
        
        return saleOrderDTO;
    }
    
    
}
