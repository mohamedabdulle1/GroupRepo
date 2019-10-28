/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.Controller;

import com.sg.SportsBlog.DAO.RolesDao;
import com.sg.SportsBlog.DAO.UsersDao;
import com.sg.SportsBlog.DTO.Roles;
import com.sg.SportsBlog.DTO.Users;
import java.io.Serializable;
import static java.lang.String.join;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Yakub Abdi
 */
@Controller
public class AdminController implements Serializable {

   @Autowired
   UsersDao usersDao;
   
   @Autowired
   RolesDao rolesDao;
      
   @Autowired
   PasswordEncoder encoder;
   @GetMapping("/")
   public String index(Model model){
       model.addAttribute("users", usersDao.findAll());
       return "index";
   }
   @PostMapping("/addUser")
   public String addUser(Users username, Users password){
       usersDao.save(username);
       usersDao.save(password);
       return "redirect:/";
   }
       
//       User user = new User();
//       user.setUsername(encoder.encode(password));
//       user.setPassword(encoder.encode(password));
//       user.setEnabled(true);
//       Set<Role> userRoles = new HashSet<>();
//       userRoles.add(roles.getRoleByRole("ROLE_USER"));
//       user.setRoles(userRoles);
//       users.createUser(user);
//       return "redirect:/admin";
   @GetMapping("/viewUsers")
   public String viewUsers(String username, String Role, Model model) {
       Users user = usersDao.findUserByUserName(username);
       List<Users> users = usersDao.findAll();
       
       model.addAttribute("Users", usersDao);
       return "Users";
   }
   
   @PostMapping("/deleteUser") // we are doing a post to delete user and are sending along is the id of user, that is the route to create on the backend
   public String deleteUser(Users username, Users password){
       usersDao.delete(username);
       usersDao.delete(password);
       return "redirect:/viewUsers?username=" + username;
       
//       users.deleteUser(id);
//       return "redirect: /admin";
   }
   @GetMapping("/editUser") // the id of the user is being sent over to us form the link so we just need to get the user based on that and all of our roles to send out to the page
   public String editUserDisplay(Model model, Integer id, Integer error){
       User user = users.getUserById(id);
       List roleList = roles.getAllRoles();
       model.addAttribute("user", user);
       model.addAttribute("roles", roleList);
       if(error != null){
           if(error == 1){
               model.addAttribute("error, Passwords did not match, passwords was not updated.");
               // now if the passwords do not match, an error will be sent to the page and displayed
           }
       }
       return "editUser";
   }
   @PostMapping(value="/editUser")
   public String editUserAction(String[] roleIdList, Boolean enabled, Integer id){
       User user = users.getUserById(id);
       if(enabled != null){
           user.setEnabled(enabled);
       }else {
           user.setEnabled(false);
       }
       Set<Role> roleList = new HashSet<>();
       for(String roleId: roleIdList){
           Role role = roles.getRoleById(Integer.parseInt(roleId));
           roleList.add(role);
       }
       user.setRoles(roleList);
       users.updateUser(user);
       return "redirect:/admin";
   }
   @PostMapping("editPassword")
   public String edipPassword(Integer id, String password, String confirmPassword){
       User user = users.getUserById(id);
       if(password.equals(confirmPassword)){
           user.setPassword(encoder.encode(password));
           users.updateUser(user);
           return "redirect:/admin";
       }else{
           return "redirect:/editUser ?id=" + id + "error=1";
       }
   }

}
