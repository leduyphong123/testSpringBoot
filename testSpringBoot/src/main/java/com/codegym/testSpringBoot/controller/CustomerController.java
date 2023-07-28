package com.codegym.testSpringBoot.controller;

import com.codegym.testSpringBoot.entity.Customer;
import com.codegym.testSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("")
    public ModelAndView getAll(){
        List<Customer> customerList = customerService.getAll();
        return new ModelAndView("index","customerList",customerList);
    }
    @GetMapping("/create")
    public ModelAndView createView(){
        return new ModelAndView("create","customer",new Customer());
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("customer") Customer customer){
        boolean isResult = customerService.create(customer);
        return new ModelAndView("create","messenger",isResult);
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editView(@PathVariable Long id ){
        Customer customer = customerService.getById(id);
        return new ModelAndView("edit","customer",customer);
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id,@ModelAttribute Customer customer){
        boolean isResult = customerService.create(customer);
        return new ModelAndView("edit","messenger",isResult);
    }
    @PostMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id){
       deleteGet(id);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteGet(@PathVariable Long id){
        customerService.delete(id);
        List<Customer> customerList = customerService.getAll();
        return new ModelAndView("index","customerList",customerList);
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String search){
        List<Customer> customerList = customerService.searchByName(search);
        return new ModelAndView("index","customerList",customerList);
    }
    @PostMapping("/search")
    public ModelAndView searchPost(@RequestParam String search){
        List<Customer> customerList = customerService.searchByName(search);
        return new ModelAndView("index","customerList",customerList);
    }
}
