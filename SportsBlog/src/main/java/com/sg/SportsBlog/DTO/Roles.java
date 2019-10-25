/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.DTO;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.springframework.context.annotation.Role;

/**
 *
 * @author mohamed
 */
@Entity
public class Roles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int roleID;
    
    @Column(name = "roles", nullable = false)
    private String roles;
    
    @Column(name = "roleid", nullable = false)
    private String rolename;
    
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Role user;
    
    @ManyToMany
    @JoinTable(name = "userroles",
            joinColumn = {
                @JoinColumn(name = "rolesid")},
            inverseJoinColumns = {
                @JoinColumn(name = "userid")})
                
    private List<Users> users;
    
    @ManyToMany(mappedBy = "roles")
    private List<Roles> role;

}