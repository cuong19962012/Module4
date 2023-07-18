package com.example.controller;

import com.example.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    private ICalculateService calculateService;

    @GetMapping("/calculate")
    public String calculate(@RequestParam double usd, @RequestParam double percent, Model model) {
        double result = calculateService.calculate(usd, percent);
        model.addAttribute("result", result);
        return "index";
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
