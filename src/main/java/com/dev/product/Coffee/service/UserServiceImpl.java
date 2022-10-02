package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.repository.RoleRepository;
import com.dev.product.Coffee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UsersEntity insert(UsersEntity usersEntity, String roleName) {
        RolesEntity userRole = roleRepository.findByName(roleName);
        usersEntity.setRoles(Collections.singletonList(userRole));
        usersEntity.setPassword(passwordEncoder.encode(usersEntity.getPassword()));
        return userRepository.save(usersEntity);
    }
    
    @Override
    public UsersEntity selectByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public UsersEntity selectByUsernameAndPassword(String username, String password) {
        UsersEntity usersEntity = this.selectByUsername(username);
        
        if (usersEntity != null) {
            if (passwordEncoder.matches(password, usersEntity.getPassword())) {
                return usersEntity;
            }
        }
        
        return null;
    }
}
