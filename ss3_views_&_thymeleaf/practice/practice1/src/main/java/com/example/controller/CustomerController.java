package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Save successfully !!!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        System.out.println(customerService.findById(id));
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer.getId(), customer);
        redirectAttributes.addFlashAttribute("success", "Update successfully !!!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String detele(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully !!!");
        return "redirect:/customer";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }
}
