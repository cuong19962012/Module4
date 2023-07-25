package com.example.excercise1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BlogType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String blogTypeName;
    @OneToMany(mappedBy = "blogType")
    private Set<Blog> blogSet;

    public BlogType() {
    }

    public BlogType(int id, String blogTypeName, Set<Blog> blogSet) {
        this.id = id;
        this.blogTypeName = blogTypeName;
        this.blogSet = blogSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogTypeName() {
        return blogTypeName;
    }

    public void setBlogTypeName(String blogTypeName) {
        this.blogTypeName = blogTypeName;
    }

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
