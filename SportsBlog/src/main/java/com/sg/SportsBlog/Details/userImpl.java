/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.Details;

import com.sg.SportsBlog.DAO.UsersDao;
import com.sg.SportsBlog.DTO.Roles;
import com.sg.SportsBlog.DTO.Users;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohamed
 */
public class userImpl {

    @Service // indicate this file is a bean that should be created at startup
    public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        UsersDao users;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Users user = users.findUserByUsername(username);
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for (Roles role : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolename()));
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
    }

}
