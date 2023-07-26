package com.example.excercise1.repository;

import com.example.excercise1.model.BlogType;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IBlogTypeRepository extends JpaRepository<BlogType, Integer> {

}
