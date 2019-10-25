/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.SportsBlog.DTO;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 *
 * @author mohamed
 */
@Entity
public class Tag {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int tagid;
    
        @ManyToOne
    @JoinColumn(name = "tagid", nullable = false)
    private Tag tag;
    

    @Column(name = "tagname", nullable = false)
    private String tagName;

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.tagid;
        hash = 83 * hash + Objects.hashCode(this.tag);
        hash = 83 * hash + Objects.hashCode(this.tagName);
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
        final Tag other = (Tag) obj;
        if (this.tagid != other.tagid) {
            return false;
        }
        if (!Objects.equals(this.tagName, other.tagName)) {
            return false;
        }
        if (!Objects.equals(this.tag, other.tag)) {
            return false;
        }
        return true;
    }



    
    
}
