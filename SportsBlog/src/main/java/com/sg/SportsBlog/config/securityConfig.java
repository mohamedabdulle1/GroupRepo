/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Yakub Abdi
 */
@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserDetailsService userDetails;// we are going to use our UserDetailsServiceImpl for authentication instead of im-memory authentication

    //@Autowired // method will run at program startup passing the authenticationmanagerbuilder
    // by using authmanagerbuilder we are setting up two users and their roles
//    public void configureGlobalInMemory(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER") // the noop is there to tell spring not to try to use a password encoder for this authentication,
//                .and()
//                .withUser("admin").password("{noop}password").roles("ADMIN", "USER");
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN") // antmatcher = match against paths into our application and indcating the type of security for that path.
                .antMatchers("/", "/home").permitAll() // hasrole limits to a specific role while permitAll lets everyone access a path. 
                .antMatchers("/css/**", "/js/**", "/fonts/**").permitAll()
                .anyRequest().hasRole("USER")// indicating security for any requests that does not match an existing pattern
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?login_error=1")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Autowired
    public void configureGlobalInDB(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(bCryptPasswordEncoder());
        // replace our existing method that sets up in-memory authentication 
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {// Another method that creates a bean of our password encoder.
        return new BCryptPasswordEncoder();
    }

}
