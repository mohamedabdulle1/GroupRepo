/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.DTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Group
 */
@Entity(name = "blogpost")
public class BlogPost {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "blogpostid")
    int blogPostID;
    
    @Column(nullable = false) 
    private String title;
    
//    @Column(nullable = false)
//    private String Author;
    
    @Column(nullable = false)
    private String post;
    
    
    @ManyToOne
    @JoinColumn(name = "userid") ///this column is the foreign key        
    Users user;
    
    
    @ManyToOne
    @JoinColumn(name = "categoryid")
    Category category;
    
    
    @Column
    LocalDate date;
    
    
    @ManyToMany
    @JoinTable(
    name = "blogposttag",
    joinColumns = @JoinColumn(name = "blogpostid"),
    inverseJoinColumns = @JoinColumn(name = "tagid"))
    List<Tag> tags;
    

    public int getBlogPostID() {
        return blogPostID;
    }

    public void setBlogPostID(int blogPostID) {
        this.blogPostID = blogPostID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getAuthor() {
//        return Author;
//    }
//
//    public void setAuthor(String Author) {
//        this.Author = Author;
//    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.blogPostID;
        hash = 17 * hash + Objects.hashCode(this.title);
//        hash = 17 * hash + Objects.hashCode(this.Author);
        hash = 17 * hash + Objects.hashCode(this.post);
        hash = 17 * hash + Objects.hashCode(this.user);
        hash = 17 * hash + Objects.hashCode(this.category);
        hash = 17 * hash + Objects.hashCode(this.date);
        hash = 17 * hash + Objects.hashCode(this.tags);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BlogPost other = (BlogPost) obj;
        if (this.blogPostID != other.blogPostID) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
//        if (!Objects.equals(this.Author, other.Author)) {
//            return false;
//        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.tags, other.tags)) {
            return false;
        }
        return true;
    }

}
