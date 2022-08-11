package com.dev.product.Coffee.config;

import com.dev.product.Coffee.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author DinhMN
 */
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(4));
//    }
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().and()
                .csrf().disable().authorizeRequests()
                .antMatchers("/api/**").hasAuthority("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }
}
