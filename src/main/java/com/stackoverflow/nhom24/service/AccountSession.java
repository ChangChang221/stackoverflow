package com.stackoverflow.nhom24.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackoverflow.nhom24.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountSession extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private String id;

    public AccountSession(String id, String username, String password,
//                           Collection<? extends GrantedAuthority>authorities
                          List<GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }

    public static AccountSession build(User user) {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(authority);

        return new AccountSession(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    public String getId(){
        return this.id;
    }

}