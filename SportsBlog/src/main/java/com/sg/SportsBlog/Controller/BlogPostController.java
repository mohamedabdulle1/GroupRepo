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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



/**
 *
 * @author mohamed
 */
@Controller
public class BlogPostController {
    
    @Autowired
    BlogPostDao BlogPost;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("BlogPosts", BlogPost.findAll());
        return "index";
    }
    
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
    
    @PostMapping("/addPosts")
    public String addPost(BlogPost blogpostID, HttpServletRequest request) {
        int blogpostId = Integer.parseInt(request.getParameter("blogpostID"));
        BlogPost blogpost = BlogPost.findById(blogpostId).orElse(null);
        blogpost.setBlogPostID(blogpostId);
        
        
       BlogPost.save(blogpost);
       return "redirect:/viewPost?blogpostID=" + blogpostID;
    }
    
    @GetMapping("/deleteBlogPost")
    public String deleteBlogPost(Integer id, Integer blogpostID) {
        BlogPost.deleteById(blogpostID);
        return "redirect:/viewPost?blogpostID=" + blogpostID;
    }
}
