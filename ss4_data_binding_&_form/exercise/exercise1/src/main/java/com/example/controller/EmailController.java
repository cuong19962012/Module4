package com.example.controller;

import com.example.model.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @ModelAttribute("languages")
    public String[] getLanguage() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] getPageSize() {
        return new int[]{5, 10, 15, 25, 50, 100};
    }

    @GetMapping("/")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", emailService.display());
        return modelAndView;
    }

    @GetMapping("showFormUpdate/{id}")
    public ModelAndView showFormUpdate(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("emailInfo", emailService.findEmail(id));
        return modelAndView;
    }

    @PostMapping("update")
    public String updateEmail(@ModelAttribute Email email,RedirectAttributes redirectAttributes) {
        emailService.updateEmail(email);
        redirectAttributes.addFlashAttribute("msg","Update successfully !");
        return "redirect:/";
    }

}
