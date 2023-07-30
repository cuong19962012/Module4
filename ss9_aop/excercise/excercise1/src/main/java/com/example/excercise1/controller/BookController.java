package com.example.excercise1.controller;


import com.example.excercise1.model.Book;
import com.example.excercise1.model.BorrowCode;
import com.example.excercise1.service.IBookService;
import com.example.excercise1.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IBorrowCodeService borrowCodeService;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> list = bookService.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("borrow/{id}")
    public String borrowBook(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        if (book != null) {
            book.setQuantity(book.getQuantity() - 1);
            redirectAttributes.addFlashAttribute("code", borrowCodeService.create(bookService.update(book)));
        } else {
            redirectAttributes.addFlashAttribute("code", "Sách hết rồi");
        }
        return "redirect:/";
    }

    @GetMapping("/giveBack")
    public String giveBack(String giveBackCode, RedirectAttributes redirectAttributes) {
        BorrowCode borrowCode = borrowCodeService.findByCode(giveBackCode);
        if (borrowCode != null) {
            borrowCode.getBook().setQuantity(borrowCode.getBook().getQuantity() + 1);
            bookService.update(borrowCode.getBook());
            borrowCodeService.remove(borrowCode);
            redirectAttributes.addFlashAttribute("code", "Trả thành công");
        } else {
            redirectAttributes.addFlashAttribute("code", "Trả thất bại ! không tìm thấy mã");
        }
        return "redirect:/";
    }
}
