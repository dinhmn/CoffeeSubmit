package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.repository.RolesRepository;
import com.dev.product.Coffee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DinhMN
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RolesRepository rolesRepository;
    
    @Override
    public UsersEntity insertUser(UsersEntity user) {
        return userRepository.save(user);
    }
    
    @Override
    public RolesEntity insertRole(RolesEntity role) {
        return rolesRepository.save(role);
    }
    
    @Override
    public void insertRoleToUser(String username, String roleName) {
        UsersEntity user = userRepository.findByUsername(username);
        RolesEntity role = rolesRepository.findByName(roleName);
        user.getRoles().add(role);
    }
    
    @Override
    public UsersEntity selectByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public List<UsersEntity> selectAll() {
        return userRepository.findAll();
    }
}
