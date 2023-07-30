package com.example.excercise1.service;

import com.example.excercise1.model.Book;

import java.util.List;

public interface IBookService {
    Book update(Book book);

    List<Book> findAll();

    Book findById(int id);
}
