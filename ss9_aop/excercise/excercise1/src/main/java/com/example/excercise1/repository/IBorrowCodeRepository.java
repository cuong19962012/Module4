package com.example.excercise1.repository;

import com.example.excercise1.model.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBorrowCodeRepository extends JpaRepository<BorrowCode, Integer> {
     BorrowCode findBorrowCodeByCode(String code);
}
