package com.example.demo.controller;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @RequestMapping(value = {"/", "customer-list"})
    public String listCustomer(Model model){
        model.addAttribute("listCustomer", customerRepository.findAll());
        return "customer-list";
    }

    @RequestMapping("/customer-save")
    public String insertCustomer(Model model){
        model.addAttribute("customerEntity", new CustomerEntity());
        return "/customer-save";
    }

    @RequestMapping("/customer-view/{id}")
    public String viewCustomer(@PathVariable int id, Model model){
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if(customerEntity.isPresent()){
            model.addAttribute("customerEntity", customerEntity.get());
        }
        return "customer-view";
    }

    @RequestMapping("/customer-update/{id}")
    public String updateCustomer(@PathVariable int id, Model model){
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if(customerEntity.isPresent()){
            model.addAttribute("customerEntity", customerEntity.get());
        }
        return "customer-update";
    }

    @RequestMapping("/saveCustomer")
    public String doSaveCustomer(@ModelAttribute("CustomerEntity") CustomerEntity customerEntity, Model model){
        customerRepository.save(customerEntity);
        model.addAttribute("listCustomer", customerRepository.findAll());
        return "customer-list";
    }

    @RequestMapping("/updateCustomer")
    public String doUpdateCustomer(@ModelAttribute("CustomerEntity") CustomerEntity customerEntity, Model model){
        customerRepository.save(customerEntity);
        model.addAttribute("listCustomer", customerRepository.findAll());
        return "customer-list";
    }

    @RequestMapping("/customerDelete/{id}")
    public String doDeleteCustomer(@PathVariable int id, Model model){
        customerRepository.deleteById(id);
        model.addAttribute("listCustomer", customerRepository.findAll());
        return "customer-list";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
