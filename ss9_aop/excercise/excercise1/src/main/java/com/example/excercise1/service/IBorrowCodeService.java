package com.example.excercise1.service;

import com.example.excercise1.model.Book;
import com.example.excercise1.model.BorrowCode;


public interface IBorrowCodeService {
    String create(Book book);

    void remove(BorrowCode borrowCode);

    BorrowCode findByCode(String code);
}
