package com.dev.product.Coffee.service;

import com.dev.product.Coffee.entity.UsersEntity;

public interface UserService {
    
    UsersEntity insert(UsersEntity usersEntity, String roleName);
    
    UsersEntity selectByUsername(String username);
    UsersEntity selectByUsernameAndPassword(String username, String password);
    
}
