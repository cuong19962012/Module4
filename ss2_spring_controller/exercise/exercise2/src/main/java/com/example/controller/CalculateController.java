package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculateController {
    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @PostMapping
    public ModelAndView cal(double input1, double input2, String submit) {
        double result = 0;
        ModelAndView modelAndView = new ModelAndView("index");
        switch (submit) {
            case "add":
                result = input1 + input2;
                break;
            case "sub":
                result = input1 - input2;
                break;
            case "mul":
                result = input1 * input2;
                break;
            case "div":
                if (input2 == 0)
                    return modelAndView.addObject("result", "Error");
                else
                    result = input1 / input2;
                break;
        }
        return modelAndView.addObject("result", result);
    }
}
