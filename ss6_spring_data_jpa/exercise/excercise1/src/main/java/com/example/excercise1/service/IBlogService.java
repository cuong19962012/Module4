package com.example.excercise1.service;

import com.example.excercise1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void delete(int id);

    List<Blog> search(String topic);
}
