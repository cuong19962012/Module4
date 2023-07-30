package com.example.excercise1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private Set<BorrowCode> borrowCodeSet;

    public Book() {
    }

    public Book(int id, String name, String author, int quantity, Set<BorrowCode> borrowCodeSet) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.borrowCodeSet = borrowCodeSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<BorrowCode> getBorrowCodeSet() {
        return borrowCodeSet;
    }

    public void setBorrowCodeSet(Set<BorrowCode> borrowCodeSet) {
        this.borrowCodeSet = borrowCodeSet;
    }
}
