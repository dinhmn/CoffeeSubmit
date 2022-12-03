package com.dev.product.Coffee.config;

import com.dev.product.Coffee.entity.UsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
  
  private String login;
  private String password;
  private Collection<? extends GrantedAuthority> grantedAuthorities;
  
  public static CustomUserDetails fromUserEntityToCustomUserDetails(UsersEntity usersEntity) {
    CustomUserDetails userDetails = new CustomUserDetails();
    userDetails.login = usersEntity.getUsername();
    userDetails.password = usersEntity.getPassword();
    userDetails.grantedAuthorities = Collections.singletonList(
        new SimpleGrantedAuthority(usersEntity.getRoles().get(0).getName()));
    
    return userDetails;
  }
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }
  
  @Override
  public String getPassword() {
    return null;
  }
  
  @Override
  public String getUsername() {
    return null;
  }
  
  @Override
  public boolean isAccountNonExpired() {
    return false;
  }
  
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  
  @Override
  public boolean isEnabled() {
    return true;
  }
}
