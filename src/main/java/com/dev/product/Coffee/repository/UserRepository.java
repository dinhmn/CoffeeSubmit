package com.dev.product.Coffee.repository;

import com.dev.product.Coffee.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends CrudRepository<UsersEntity, Long> {
    
    public List<UsersEntity> findByEmail(String email);
    
}
