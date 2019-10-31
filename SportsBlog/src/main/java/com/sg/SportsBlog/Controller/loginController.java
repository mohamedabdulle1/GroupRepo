/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.Controller;

import com.sg.SportsBlog.DAO.BlogPostDao;
import com.sg.SportsBlog.DTO.BlogPost;
import com.sg.SportsBlog.DTO.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Group
 */
@Controller
public class loginController {
     @Autowired
    BlogPostDao BlogPost;

   @GetMapping("/login")
   public String showLoginForm(){
       return "login";
   }
       @PostMapping("/login")
    public String addLogin(BlogPost post){
        BlogPost.save(post);
        return "redirect:/login";
    }
     
}
