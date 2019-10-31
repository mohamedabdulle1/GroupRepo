/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.Controller;

import com.sg.SportsBlog.DAO.BlogPostDao;
import com.sg.SportsBlog.DAO.CategoryDao;
import com.sg.SportsBlog.DAO.RolesDao;
import com.sg.SportsBlog.DAO.TagDao;
import com.sg.SportsBlog.DAO.UsersDao;
import com.sg.SportsBlog.DTO.BlogPost;
import com.sg.SportsBlog.DTO.Users;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



/**
 *
 * @author Group
 */
@Controller
public class BlogPostController {
    
    @Autowired
    BlogPostDao BlogPost;
    
    
    @Autowired
    UsersDao UserPost;
    
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("BlogPosts", BlogPost.findAll());
        return "home";
    }  // sort blogpost by newest posts
    
    @PostMapping("/BlogPost")
    public String addBlogPost(BlogPost post) {
        BlogPost.save(post);
        return "redirect:/";
    }
    
    @GetMapping("/viewPost")
    public String BlogPost(Integer blogpostID, Model model) {
        BlogPost post = BlogPost.findById(blogpostID).orElse(null);
        List<BlogPost> postList = BlogPost.findAll();
        
        model.addAttribute("BlogPost", BlogPost);
        model.addAttribute("Posts", postList);
        
        return "Post";
    
    }
    
    @GetMapping("/deleteBlogPost")
    public String deleteBlogPost(Integer id, Integer blogpostID) {
        BlogPost.deleteById(blogpostID);
        return "redirect:/viewPost?blogpostID=" + blogpostID;
    }
     @GetMapping("/boxing")
    public String Boxingindex(Model model) {
        model.addAttribute("BlogPosts", BlogPost.findAll());
        return "boxing";
    }  // sort blogpost by newest p
    
      @PostMapping("/boxing")
    public String addBoxing(BlogPost post) {
        BlogPost.save(post);
        return "redirect:/boxing";
    }
    
     @GetMapping("/contentcreation")
    public String  blogPosts(Model model) {
        List<BlogPost> posts = BlogPost.findAll();
        model.addAttribute("BlogPosts", posts);
        return "contentcreation";
    }  // sort blogpost by newest p
    
      @PostMapping("/contentcreation")
    public String addPost(BlogPost post) {
        Authentication authenication = SecurityContextHolder.getContext().getAuthentication();
        String name = authenication.getName();
        Users user = UserPost.findUserByUsername(name);
        post.setBlogPostID(user.getUsersId());
        BlogPost.save(post);
        return "redirect:/contentcreation";
    }
    @GetMapping("/basketball")
    public String BasketballIndex(Model model){
        model.addAttribute("BlogPosts", BlogPost.findAll());
        return "basketball";
    }
    @PostMapping("/basketball")
    public String addBasketball(BlogPost post){
        BlogPost.save(post);
        return "redirect:/basketball";
        
    }
    @GetMapping("/aboutus")
    public String aboutIndex(Model model){
        model.addAttribute("BlogPosts", BlogPost.findAll());
        return "about";
    }
    @PostMapping("/aboutus")
    public String addAboutUs(BlogPost post){
        BlogPost.save(post);
        return "redirect:/aboutus";
    }  
  
//    @GetMapping("/Admin")
//    public String Added{
//        Users.save(posted);
//        return "redirect:/";
//    }
}

