package com.dev.product.Coffee.service;

import com.dev.product.Coffee.dto.*;
import com.dev.product.Coffee.entity.*;
import com.dev.product.Coffee.mapper.CartItemMapper;
import com.dev.product.Coffee.mapper.SaleOrderProductsMapper;
import com.dev.product.Coffee.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleOrderServiceImpl implements SaleOrderService {
    
    @Autowired
    private UserService userService;
    
    @Override
    public List<SaleOrderEntity> selectAll() {
        return null;
    }
    
    @Override
    public SaleOrderEntity selectByPrimaryKey(Long id) {
        return null;
    }
    
    @Override
    public SaleOrderEntity insert(SaleOrderDTO saleOrderDTO, Long userId) {
        SaleOrderEntity saleOrderEntity = new SaleOrderEntity();
        Optional<UsersEntity> user = userService.selectByUserId(userId);
        List<SaleOrderProductsEntity> saleOrderProductsEntityList =
                saleOrderDTO.getSaleOrderProductsDTOList().stream()
                        .map(saleOrderProductsDTO -> SaleOrderProductsMapper.getInstance().toEntity(saleOrderProductsDTO))
                        .collect(Collectors.toList());
        user.ifPresent(saleOrderEntity::setUser);
        saleOrderEntity.setPaymentEntity(toPaymentEntity(saleOrderDTO.getPaymentDTO()));
        saleOrderEntity.setDeliveryEntity(toDeliveryEntity(saleOrderDTO.getDeliveryDTO()));
        saleOrderEntity.setCustomerEntity(toCustomerEntity(saleOrderDTO.getCustomerDTO()));
        saleOrderEntity.setSaleOrderProducts(saleOrderProductsEntityList);
        saleOrderEntity.setCode(String.valueOf(System.currentTimeMillis()));
        saleOrderEntity.setTotal(totalProductPrice(saleOrderDTO.getCartItemsDTOList()));
        saleOrderEntity.setIsStatus(saleOrderDTO.getIsStatus());
        saleOrderEntity.setCreatedDate(new Date());
        return saleOrderEntity;
    }
    
    @Override
    public boolean delete(Long id) {
        return false;
    }
    
    @Override
    public SaleOrderEntity update(Long id, SaleOrderEntity saleOrderEntity) {
        return null;
    }
    
    private BigDecimal totalProductPrice(List<CartItemsDTO> cartItemsDTOList) {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItemsDTO item : cartItemsDTOList) {
            BigDecimal price = item.getProductPrice();
            BigDecimal quantity = BigDecimal.valueOf(item.getQuantity());
            total = total.add(price.multiply(quantity));
        }
        return total;
    }
    
    private PaymentEntity toPaymentEntity(PaymentDTO paymentDTO) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setCreatedBy(paymentEntity.getCreatedBy());
        paymentEntity.setCreatedDate(paymentEntity.getCreatedDate());
        paymentEntity.setUpdatedBy(paymentEntity.getUpdatedBy());
        paymentEntity.setUpdatedDate(paymentEntity.getUpdatedDate());
        paymentEntity.setStatus(paymentEntity.getStatus());
        paymentEntity.setFormPayment(paymentDTO.getPayment());
        return paymentEntity;
    }
    
    private DeliveryEntity toDeliveryEntity(DeliveryDTO deliveryDTO) {
        DeliveryEntity deliveryEntity = new DeliveryEntity();
        deliveryEntity.setCreatedBy(deliveryDTO.getCreatedBy());
        deliveryEntity.setCreatedDate(deliveryDTO.getCreatedDate());
        deliveryEntity.setUpdatedBy(deliveryDTO.getUpdatedBy());
        deliveryEntity.setUpdatedDate(deliveryDTO.getUpdatedDate());
        deliveryEntity.setStatus(deliveryDTO.getStatus());
        deliveryEntity.setDelivery(deliveryDTO.getDelivery());
        deliveryEntity.setIsActive(deliveryDTO.getIsActive());
        return deliveryEntity;
    }
    
    private CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedBy(customerDTO.getCreatedBy());
        customerEntity.setCreatedDate(customerDTO.getCreatedDate());
        customerEntity.setUpdatedBy(customerDTO.getUpdatedBy());
        customerEntity.setUpdatedDate(customerDTO.getUpdatedDate());
        customerEntity.setStatus(customerDTO.getStatus());
        customerEntity.setName(customerDTO.getCustomerName());
        customerEntity.setAddress(customerDTO.getCustomerAddress());
        customerEntity.setPhone(customerDTO.getCustomerPhone());
        customerEntity.setAge(customerDTO.getCustomerAge());
        customerEntity.setEmail(customerDTO.getCustomerEmail());
        
        return customerEntity;
    }
}
