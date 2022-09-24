package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.dto.SaleOrderDTO;
import com.dev.product.Coffee.entity.SaleOrderEntity;
import com.dev.product.Coffee.service.CartService;
import com.dev.product.Coffee.service.CustomerService;
import com.dev.product.Coffee.service.ProductService;
import com.dev.product.Coffee.service.SaleOrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author DinhMN
 */
@RestController
@RequestMapping("/api/cart")
@AllArgsConstructor
public class CartController {
    
    @Autowired
    private final ProductService productService;
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final SaleOrderService saleOrderService;
    
    @GetMapping("/view/{userId}")
    public List<SaleOrderDTO> getCart(HttpSession session,
                                      @PathVariable(value = "productId") Long productId,
                                      @PathVariable String userId) {
        return null;
    }
    
    @PostMapping("/add")
    public ResponseEntity<SaleOrderDTO> insertCart(@RequestBody SaleOrderDTO saleOrderDTO,
                                                   @RequestBody Long userId) {
        if (userId == 0) {
            return null;
        }
        SaleOrderEntity saleOrderEntity = saleOrderService.insert(saleOrderDTO, userId);
        
        return new ResponseEntity<>(saleOrderDTO, HttpStatus.OK);
    }
}
