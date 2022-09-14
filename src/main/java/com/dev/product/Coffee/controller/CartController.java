package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.dto.CartDTO;
import com.dev.product.Coffee.service.CartService;
import com.dev.product.Coffee.service.CustomerService;
import com.dev.product.Coffee.service.ProductService;
import com.dev.product.Coffee.service.SaleOrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
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
    private final SaleOrderService orderService;
    @Autowired
    private final CartService cartService;
    
    @GetMapping("/view/{userId}")
    public List<CartDTO> getCart(HttpSession session,
                                 @PathVariable(value = "productId") Long productId,
                                 @PathVariable String userId) {
        return null;
    }
    
    @PostMapping("/add")
    public CartDTO insertCart(@RequestBody CartDTO cartDTO,
                              @RequestBody Long userId,
                              @RequestBody Long productId) {
        if (userId == 0) {
            return null;
        }
        return cartService.insert(userId, productId, cartDTO);
    }
}
