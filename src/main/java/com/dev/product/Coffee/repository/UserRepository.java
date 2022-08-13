package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    
    List<UsersEntity> findByEmail(String email);
    UsersEntity findByUsername(String username);
}
