package com.dev.product.Coffee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author DinhMN
 */
@Configuration
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    
//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService()
//    }
}
