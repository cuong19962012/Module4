package com.example.excercise1.common;

import com.example.excercise1.model.Book;
import com.example.excercise1.model.BorrowCode;
import com.example.excercise1.service.IBookService;
import com.example.excercise1.service.IBorrowCodeService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @Autowired
    IBookService bookService;
    @Autowired
    IBorrowCodeService borrowCodeService;

    @After("execution(* com.example.excercise1.controller.BookController.borrowBook(..))")
    public void loggingInfoBorrowBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Book book = bookService.findById((int) args[0]);
        System.out.println("Khách đã mượn 1 cuốn tên" + book.getName());
    }

    @Before("execution(* com.example.excercise1.controller.BookController.giveBack(..))")
    public void loggingInfoGiveBackBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        BorrowCode borrowCode = borrowCodeService.findByCode(String.valueOf(args[0]));
        System.out.println("Khách đã trả 1 cuốn tên " + borrowCode.getBook().getName());
    }
}
