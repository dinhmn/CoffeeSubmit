package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UsersEntity, Long> {
    
    List<UsersEntity> findByEmail(String email);
    
    UsersEntity selectByUsername(String userName);
}
