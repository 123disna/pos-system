package com.frontendpos.posfrontend.service.impl;

import com.frontendpos.posfrontend.entity.Customer;
import com.frontendpos.posfrontend.repo.CustomerRepo;
import com.frontendpos.posfrontend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer updateCustomer(Customer existCustomer) {
        return customerRepo.save(existCustomer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
}
