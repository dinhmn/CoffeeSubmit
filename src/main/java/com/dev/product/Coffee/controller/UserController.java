package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    
    @PostMapping("/user/save")
    public ResponseEntity<UsersEntity> saveUser(@RequestBody UsersEntity usersEntity) {

        return ResponseEntity.created(null).body(userService.insert(usersEntity));
    }
    
    @PostMapping("/role/save")
    public ResponseEntity<RolesEntity> saveRole(@RequestBody RolesEntity rolesEntity) {
        return ResponseEntity.ok().body(userService.insert(rolesEntity));
    }
}
