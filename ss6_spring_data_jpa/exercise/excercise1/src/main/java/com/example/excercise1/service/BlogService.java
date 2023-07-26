package com.example.excercise1.service;

import com.example.excercise1.model.Blog;
import com.example.excercise1.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable, String topic) {
        return blogRepository.findAllByTopicContaining(pageable, topic);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> search(String topic) {
        return blogRepository.findAllByTopic(topic);
    }

}
