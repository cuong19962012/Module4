package com.example.excercise2.controller;

import com.example.excercise2.model.MusicDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MusicController {
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("register", "musicDto", new MusicDto());
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
            modelAndView.addObject("musicDto", musicDto);
            return modelAndView;
        }
        modelAndView.setViewName("show");
        modelAndView.addObject("musicDto", musicDto);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(MusicDto musicDto) {
        System.out.println(musicDto);
        return new ModelAndView("edit", "musicDto", musicDto);
    }
}
