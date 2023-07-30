package com.example.excercise1.model;

import javax.persistence.*;

@Entity
public class BorrowCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public BorrowCode() {
    }

    public BorrowCode(String code, Book book) {
        this.code = code;
        this.book = book;
    }

    public BorrowCode(int id, String code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BorrowCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", book=" + book +
                '}';
    }
}
