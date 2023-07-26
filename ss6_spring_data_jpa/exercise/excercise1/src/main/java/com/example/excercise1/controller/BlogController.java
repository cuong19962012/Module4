package com.example.excercise1.controller;

import com.example.excercise1.model.Blog;
import com.example.excercise1.service.IBlogService;
import com.example.excercise1.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("/")
    public ModelAndView showAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String keySearch) {
        ModelAndView modelAndView = new ModelAndView("home");
        Pageable pageable = PageRequest.of(page, 1, Sort.by("topic").ascending());
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("keySearch", keySearch);
        modelAndView.addObject("blogTypes", blogTypeService.findAll());
        modelAndView.addObject("blogs", blogService.findAll(pageable, keySearch));
        if (blogService.findAll(pageable, keySearch).getSize() == 0) {
            modelAndView.addObject("msg1", "List is empty");
        }
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Create successfully !!!");
        return "redirect:/";
    }

    //
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Remove successfully !!!");
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Update successfully !!!");
        return "redirect:/";
    }

//    @GetMapping("/search")
//    public ModelAndView search(@RequestParam String topic) {
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("blogs", blogService.search(topic));
//        modelAndView.addObject("msg1", "Searched " + blogService.search(topic).size() + " items");
//        modelAndView.addObject("keySearch", topic);
//        modelAndView.addObject("blog", new Blog());
//        modelAndView.addObject("blogTypes", blogTypeService.findAll());
//        return modelAndView;
//    }

}
