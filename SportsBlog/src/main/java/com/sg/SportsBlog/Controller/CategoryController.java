/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.Controller;

import com.sg.SportsBlog.DAO.CategoryDao;
import com.sg.SportsBlog.DTO.Category;
import java.util.List;
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
public class CategoryController {
    
    @Autowired
    CategoryDao Category;
    
    @GetMapping("/category")
    public String index(Model model) {
        model.addAttribute("Categories", Category.findAll());
        return "home";
    }
    @PostMapping("/addCategory")
    public String addCategory(Category category) {
        Category.save(category);
        return "redirect:/";
    }
    @GetMapping("/viewCategory")
    public String viewCategory(Integer categoryID, Model model) {
       Category category = Category.findById(categoryID).orElse(null);
       List<Category> categories = Category.findAll();
       
       model.addAttribute("Category", Category);
       model.addAttribute("Posts", categories);
       
       return "Category";
    }
    @PostMapping("/deleteCategory")
    public String deleteCategory(Integer id, Integer categoryID) {
        Category.deleteById(categoryID);
        return "redirect:/viewCategory?categoryID=" + categoryID;
    }
}
