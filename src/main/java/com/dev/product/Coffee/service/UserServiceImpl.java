package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.repository.RolesRepository;
import com.dev.product.Coffee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;

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
        log.info("Saving new user {} to the database", user.getUsername());
        RolesEntity userRole = rolesRepository.findByName("USERS");
        user.setRoles(Collections.singleton(userRole));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    @Override
    public RolesEntity insert(RolesEntity role) {
        log.info("Saving new role {} to the database", role.getName());
        return rolesRepository.save(role);
    }
    
    @Override
    public void insertRoleToUser(String userName, String roleName) {
        UsersEntity user = userRepository.findByUsername(userName);
        RolesEntity role = rolesRepository.findByName(roleName);
        user.getRoles().add(role);
    }
    
    @Override
    public UsersEntity selectByUserName(String userName) throws UsernameNotFoundException {
        UsersEntity users = userRepository.findByUsername(userName);
        if (Objects.isNull(users)) {
            throw new UsernameNotFoundException(userName);
        }
        return users;
    }
    
    @Override
    public List<UsersEntity> selectAll() {
        return userRepository.findAll();
    }
}
