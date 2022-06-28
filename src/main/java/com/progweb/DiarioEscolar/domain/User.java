package com.progweb.DiarioEscolar.domain;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.progweb.DiarioEscolar.domain.enums.Authority;


public class User implements UserDetails{
    private static final long serialVerionUID = 1L;

    private Long id;
    private String userName;
    private String password;
    private Collection<? extends GrantedAuthority> Authorities;


    public Long getId(){
        return id;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    //conta nao esta expirada?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //conta nao esta fechada?
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //as credencias nao estao expiradas?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //esta habilitado?
    @Override
    public boolean isEnabled() {
        return true;
    }
    public User(Long id, String userName, String password, Set<Authority> authority) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        Authorities = authority.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toSet());
    }

    
    
}