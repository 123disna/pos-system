package com.frontendpos.posfrontend.service;

import com.frontendpos.posfrontend.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer addCustomer(Customer customer);

    Customer getCustomerById(int id);

    Customer updateCustomer(Customer existCustomer);

    void deleteCustomer(int id);
}
