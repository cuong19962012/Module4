package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @PostMapping
    public String save(String condiment, Model model) {
        String result = "";
        if (condiment != null) {
            result += condiment;
        } else {
            result += "None condiment";
        }
        model.addAttribute("result", result);
        return "index";
    }
}
