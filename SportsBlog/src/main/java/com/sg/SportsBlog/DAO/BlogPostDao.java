/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.DAO;

import com.sg.SportsBlog.DTO.BlogPost;
import com.sg.SportsBlog.DTO.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Group
 */
@Repository
public interface BlogPostDao extends JpaRepository<BlogPost, Integer> {
    
    List<BlogPost> findByCategory(Category category);
    
}
