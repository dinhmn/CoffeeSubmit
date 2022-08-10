package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DinhMN
 */
@RestController
@RequestMapping("/api/u1")
@RequiredArgsConstructor
public class UserController {
    
    @Autowired
    private final UserService userService;
    
    @GetMapping("/users")
    public ResponseEntity<List<UsersEntity>> getUsers() {
        return ResponseEntity.ok().body(userService.selectAll());
    }
}
