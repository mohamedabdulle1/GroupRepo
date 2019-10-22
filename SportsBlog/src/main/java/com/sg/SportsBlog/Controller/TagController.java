/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.Controller;

import com.sg.SportsBlog.DAO.TagDao;
import com.sg.SportsBlog.DTO.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Yakub Abdi
 */
public class TagController {
    
    @Autowired
    TagDao Tag;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("Tag", Tag.findAll());
        return "index";
    }
    @PostMapping("/addTag")
    public String addTag(Tag tag) {
        Tag.save(tag);
        return "redirect:/";
    }
    @GetMapping("viewTag")
    public String viewTag(Integer tagID, Model model) {
        Tag tag = Tag.findById(tagID).orElse(null);
        List<Tag> tags = Tag.findAll();
        
        model.addAttribute("Tag", Tag);
        model.addAttribute("Posts", tag);
        
        return "Tag";
    }
    @PostMapping("/deleteTag")
    public String deleteTag(Integer id, Integer tagID) {
        Tag.deleteById(tagID);
        return "redirect:/viewTag?tagID=" + tagID;
    }
            
}
