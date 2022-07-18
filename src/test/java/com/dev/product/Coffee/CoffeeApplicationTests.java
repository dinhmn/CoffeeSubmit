package com.dev.product.Coffee;

import com.dev.product.Coffee.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CoffeeApplicationTests {

	@Autowired
	private ProductRepository repository;
	
	@Test
	void contextLoads() {
	}


}
