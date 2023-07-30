package com.example.excercise1.service;

import com.example.excercise1.model.Book;
import com.example.excercise1.model.BorrowCode;
import com.example.excercise1.repository.IBorrowCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BorrowCodeService implements IBorrowCodeService {
    @Autowired
    IBorrowCodeRepository borrowCodeRepository;

    @Override
    public String create(Book book) {
        String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        StringBuilder s = new StringBuilder(5);
        String result;
        for (int i = 0; i < 5; i++) {
            int ch = (int) (randomString.length() * Math.random());
            s.append(randomString.charAt(ch));
        }
        result = String.valueOf(s);
        borrowCodeRepository.save(new BorrowCode(result, book));
        return result;
    }

    @Override
    public void remove(BorrowCode borrowCode) {
        borrowCodeRepository.delete(borrowCode);
    }

    @Override
    public BorrowCode findByCode(String code) {
        return borrowCodeRepository.findBorrowCodeByCode(code);
    }

}
