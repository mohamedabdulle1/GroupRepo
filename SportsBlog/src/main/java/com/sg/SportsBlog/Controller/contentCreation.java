/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.Controller;

import com.sg.SportsBlog.DAO.BlogPostDao;
import com.sg.SportsBlog.DAO.CategoryDao;
import com.sg.SportsBlog.DTO.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Group
 */
@Controller
public class contentCreation {
    
    @Autowired
    CategoryDao Category;
    
    @Autowired
    BlogPostDao BlogPost;
    
    @GetMapping("contentCreation")
    public String index(Model model) {
        model.addAttribute("contentCreation");
        return "contentCreation";
    }
    @PostMapping("/contentCreation")
    public String contentCreation(BlogPost blogpost) {
        BlogPost.save(blogpost);
        return "redirect:/";
    }
}
