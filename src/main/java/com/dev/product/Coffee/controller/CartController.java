package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.service.CustomerService;
import com.dev.product.Coffee.service.ProductService;
import com.dev.product.Coffee.service.SaleOrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DinhMN
 */
@RestController
@RequestMapping("/api/cart/")
@AllArgsConstructor
public class CartController {
    
    @Autowired
    private final ProductService productService;
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final SaleOrderService orderService;
    
    
}
