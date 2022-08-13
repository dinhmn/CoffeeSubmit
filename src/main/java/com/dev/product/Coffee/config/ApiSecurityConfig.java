package com.dev.product.Coffee.config;

import com.dev.product.Coffee.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author DinhMN
 */
@EnableWebSecurity
@Configuration
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(4));
        try {
            auth.inMemoryAuthentication()
                    .withUser("user").password("{noop}password").roles("USER")
                    .and()
                    .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/", "/home", "/user/**", "/api/**", "/admin/api/**").permitAll()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/admin/api/**").hasAuthority("admin")
                .antMatchers("/api/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }
}
