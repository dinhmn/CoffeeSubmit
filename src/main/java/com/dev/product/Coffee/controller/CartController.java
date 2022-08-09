package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.common.ApiResponse;
import com.dev.product.Coffee.dto.CartDTO;
import com.dev.product.Coffee.service.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private SaleOrderService cartService;
    
    // post cart api
    public ResponseEntity<ApiResponse> addToCart(@RequestBody CartDTO cartDTO){
        // authenticate the token
        
        // find the user
        
        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.OK);
    }
    
    // get all cart items for a user
    
    // delete a cart item for a user
}
