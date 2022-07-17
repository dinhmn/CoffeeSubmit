package com.dev.product.Coffee.config;

import com.dev.product.Coffee.filterImpl.ProductFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    
    @Bean
    public FilterRegistrationBean<ProductFilter> loggingFilter() {
        FilterRegistrationBean<ProductFilter> registrationBean
                = new FilterRegistrationBean<>();
        
        registrationBean.setFilter(new ProductFilter());
        registrationBean.addUrlPatterns("/api/p1/*");
        
        return registrationBean;
    }
    
}
