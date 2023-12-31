package com.example.excercise1.repository;

import com.example.excercise1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByTopic(String topic);

    Page<Blog> findAllByTopicContaining(Pageable pageable, String topic);
}
