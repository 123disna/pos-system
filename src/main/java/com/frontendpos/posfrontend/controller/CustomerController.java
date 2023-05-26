package com.frontendpos.posfrontend.controller;

import com.frontendpos.posfrontend.entity.Customer;
import com.frontendpos.posfrontend.entity.Item;
import com.frontendpos.posfrontend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public String listAllCustomers(Model model){
        model.addAttribute("customers",service.getAllCustomers());
        return "customers";
    }

    @GetMapping("/customers/new")
    public String createCustomer(Model model){
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "create_customer";
    }

    @PostMapping("/customers")
    public String saveAllCustomer(@ModelAttribute("customer")Customer customer){
        service.addCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomerForm(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("customer",service.getCustomerById(id));
        return "edit_customer";
    }

    @PostMapping("/customers/{id}")
    public String updateItem(@PathVariable int id,
                             @ModelAttribute("customer") Customer customer,
                             Model model){
        Customer existCustomer=service.getCustomerById(id);
        existCustomer.setName(customer.getName());
        existCustomer.setAddress(customer.getAddress());
        existCustomer.setPhone(customer.getPhone());
        existCustomer.setNic(customer.getNic());

        service.updateCustomer(existCustomer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/{id}")
    public String deleteItem(@PathVariable int id){
        service.deleteCustomer(id);
        return "redirect:/customers";
    }
}
