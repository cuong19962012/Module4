package com.example.excercise1.controller;

import com.example.excercise1.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("signup", "userDto", new UserDto());
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        System.out.println(userDto);
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "signup";
        }
        return "index";
    }
}
