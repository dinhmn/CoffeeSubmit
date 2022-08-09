package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.repository.RolesRepository;
import com.dev.product.Coffee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author DinhMN
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    
    @Override
    public UsersEntity insert(UsersEntity user) {
        return userRepository.save(user);
    }
    
    @Override
    public RolesEntity insert(RolesEntity role) {
        return rolesRepository.save(role);
    }
    
    @Override
    public void insertRoleToUser(String userName, String roleName) {
    
    }
    
    @Override
    public UsersEntity selectByUserName(String userName) {
        return null;
    }
    
    @Override
    public List<UsersEntity> selectAll() {
        return null;
    }
}
