package com.example.excercise1.service;

import com.example.excercise1.model.BlogType;
import com.example.excercise1.repository.IBlogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeService implements IBlogTypeService {
    @Autowired
    private IBlogTypeRepository blogTypeRepository;

    @Override
    public List<BlogType> findAll() {
        return blogTypeRepository.findAll();
    }

    @Override
    public void create(BlogType blogType) {
        blogTypeRepository.save(blogType);
    }

    @Override
    public void delete(BlogType blogType) {
        blogTypeRepository.delete(blogType);
    }

    @Override
    public BlogType findById(int id) {
        return blogTypeRepository.findById(id).get();
    }

}
