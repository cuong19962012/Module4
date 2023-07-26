package com.example.excercise1.service;

import com.example.excercise1.model.BlogType;

import java.util.List;

public interface IBlogTypeService {
    List<BlogType> findAll();

    void create(BlogType blogType);

    void delete(BlogType blogType);


}
