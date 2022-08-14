package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.dto.UserDTO;
import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.mapper.UserMapper;
import com.dev.product.Coffee.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DinhMN
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/api")
public class UserController {
    
    @Autowired
    private final UserService userService;
    
    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UsersEntity> userList = userService.selectAll();
        List<UserDTO> userDTOList = userList
                .stream()
                .map(user -> UserMapper.getInstance().toDTO(user))
                .collect(Collectors.toList());
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }
    
    @PostMapping("/user/save")
    public ResponseEntity<UsersEntity> saveUser(@RequestBody UsersEntity user) {
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/admin/api/user/save")
                        .toUriString());
        return ResponseEntity.created(uri).body(userService.insertUser(user));
    }
    
    @PostMapping("/role/save")
    public ResponseEntity<RolesEntity> saveRole(@RequestBody RolesEntity role) {
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/admin/api/role/save")
                        .toUriString());
        return ResponseEntity.created(uri).body(userService.insertRole(role));
    }
    
    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.insertRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}