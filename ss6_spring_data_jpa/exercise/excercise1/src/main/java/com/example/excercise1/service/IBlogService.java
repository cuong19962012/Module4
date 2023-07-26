package com.example.excercise1.service;

import com.example.excercise1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable,String topic);

    void save(Blog blog);

    void delete(int id);

    List<Blog> search(String topic);
}
