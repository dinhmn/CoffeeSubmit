package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.jwt.JwtProvider;
import com.dev.product.Coffee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DinhMN
 */
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class RegisterController {



//  @PostMapping("/login")
//  public ResponseEntity<UsersEntity> authenticateUser(@Valid @RequestBody User)

}
