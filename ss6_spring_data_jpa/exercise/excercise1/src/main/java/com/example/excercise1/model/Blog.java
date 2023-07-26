package com.example.excercise1.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String topic;
    private String content;
    private String author;
    @ManyToOne
    @JoinColumn(name = "blog_type_id", referencedColumnName = "id")
    private BlogType blogType;

    public Blog() {
    }

    public Blog(int id, String topic, String content, String author, BlogType blogType) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.author = author;
        this.blogType = blogType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
