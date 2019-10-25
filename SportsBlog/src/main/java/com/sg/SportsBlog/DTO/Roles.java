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
            joinColumns = {
                @JoinColumn(name = "rolesid")},
            inverseJoinColumns = {
                @JoinColumn(name = "userid")})
                
    private List<Users> users;
    
    @ManyToMany(mappedBy = "roles")
    private List<Roles> role;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Role getUser() {
        return user;
    }

    public void setUser(Role user) {
        this.user = user;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public List<Roles> getRole() {
        return role;
    }

    public void setRole(List<Roles> role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.roleID;
        hash = 29 * hash + Objects.hashCode(this.roles);
        hash = 29 * hash + Objects.hashCode(this.rolename);
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.users);
        hash = 29 * hash + Objects.hashCode(this.role);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Roles other = (Roles) obj;
        if (this.roleID != other.roleID) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.rolename, other.rolename)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }

    
}