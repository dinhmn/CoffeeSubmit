package com.dev.product.Coffee.test;

import com.dev.product.Coffee.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RequiredArgsConstructor

public class CommonContactServiceImplTest {
    
    @Autowired
    private final ContactService contactService;
    
    @DisplayName("Unit Test")
    @Test
    void Register_OK1() {
    
    }
    
}
