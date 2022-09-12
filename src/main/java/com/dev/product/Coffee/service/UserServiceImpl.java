package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.RolesEntity;
import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.repository.RolesRepository;
import com.dev.product.Coffee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author DinhMN
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity = userRepository.findByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException("User not found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usersEntity.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new User(usersEntity.getUsername(), usersEntity.getPassword(), authorities);
    }
    
    @Override
    public UsersEntity insertUser(UsersEntity user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
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
    public Optional<UsersEntity> selectByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public Optional<UsersEntity> selectByUserId(Long userId) {
        return userRepository.findById(userId);
    }
    
    @Override
    public List<UsersEntity> selectAll() {
        return userRepository.findAll();
    }
    
}
