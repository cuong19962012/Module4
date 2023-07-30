package com.example.excercise1.repository;

import com.example.excercise1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer>{
    Book findBookByIdIs(int id);
}
