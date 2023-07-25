package com.example.excercise1.controller;

import com.example.excercise1.model.Blog;
import com.example.excercise1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("home");
        if (blogService.findAll() != null) {
            modelAndView.addObject("blog", new Blog());
            modelAndView.addObject("blogs", blogService.findAll());
            return modelAndView;
        } else {
            modelAndView.addObject("blog", new Blog());
            modelAndView.addObject("msg1", "List is empty");
            return modelAndView;
        }
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("msg", "Create successfully !!!");
        return "redirect:/";
    }
//
//    @GetMapping("/remove/{id}")
//    public String remove(@PathVariable int id, RedirectAttributes redirectAttributes) {
//        productService.remove(id);
//        redirectAttributes.addFlashAttribute("msg", "Remove successfully !!!");
//        return "redirect:/";
//    }
//
//    @PostMapping("/edit")
//    public String edit(Product product, RedirectAttributes redirectAttributes) {
//        productService.update(product.getId(), product);
//        redirectAttributes.addFlashAttribute("msg", "Update successfully !!!");
//        return "redirect:/";
//    }
//
//    @GetMapping("/search")
//    public ModelAndView search(@RequestParam String nameProduct) {
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("products", productService.search(nameProduct));
//        modelAndView.addObject("msg1", "Searched " + productService.search(nameProduct).size() + " items");
//        modelAndView.addObject("keySearch", nameProduct);
//        modelAndView.addObject("product", new Product());
//        return modelAndView;
//    }

}
