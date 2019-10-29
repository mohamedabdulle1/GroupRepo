/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.DAO;

import com.sg.SportsBlog.DTO.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Group
 */
@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{
    
}
