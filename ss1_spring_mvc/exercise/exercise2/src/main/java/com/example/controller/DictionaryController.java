package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String input, Model model) {
        model.addAttribute("output", dictionaryService.translate(input));
        return "index";
    }
}
