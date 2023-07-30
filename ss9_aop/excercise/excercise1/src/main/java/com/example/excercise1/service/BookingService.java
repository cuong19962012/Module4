package com.example.excercise1.service;

import com.example.excercise1.model.Book;
import com.example.excercise1.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        Book book = bookRepository.findBookByIdIs(id);
        if (book.getQuantity() < 1)
            return null;
        return book;
    }

}
