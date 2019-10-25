/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.Controller;

import com.sg.SportsBlog.DAO.RolesDao;
import com.sg.SportsBlog.DAO.UsersDao;
import com.sg.SportsBlog.DTO.Roles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Yakub Abdi
 */
public class RolesController {
    
    @Autowired
    RolesDao Roles;
    UsersDao Users;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("Roles", Roles.findAll());
        return "index";
    }
    @PostMapping("/addRoles")
    public String addRoles(Roles roles) {
        Roles.save(roles);
        return "redirect:/";
    }
    @GetMapping("/viewRoles")
    public String viewRoles(Integer rolesID, Model model) {
        Roles role = Roles.findById(rolesID).orElse(null);
        List<Roles> roles = Roles.findAll();
        
        model.addAttribute("Roles", Roles);
        model.addAttribute("Users", Users);
        
        return "Roles";
    }
    @PostMapping("/deleteRoles")
    public String deleteRoles(Integer id, Integer rolesID) {
        Roles.deleteById(rolesID);
        return "redirect:/viewRoles?rolesID=" + rolesID;
    }
}

