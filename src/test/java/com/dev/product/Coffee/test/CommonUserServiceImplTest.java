package com.dev.product.Coffee.test;

import com.dev.product.Coffee.entity.UsersEntity;
import com.dev.product.Coffee.repository.UserRepository;
import com.dev.product.Coffee.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DinhMN
 */
@ExtendWith(MockitoExtension.class)
public class CommonUserServiceImplTest {
    
    @Mock
    UserRepository repository;
    
    @InjectMocks
    UserService service;
    
    @DisplayName("Unit test")
    @Test
    void findAll() {
        // 1. create mock data
        
    }
    
}
