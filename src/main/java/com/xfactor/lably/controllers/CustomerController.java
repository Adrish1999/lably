package com.xfactor.lably.controllers;

import java.util.List;

import com.xfactor.lably.entity.Customer;
import com.xfactor.lably.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController
{

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/registerCustomer")
    public Customer registerCustomer(@RequestBody Customer customer)
    {
        Customer persistedCustomer = customerRepository.save(customer);
        return persistedCustomer;
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers()
    {
        List<Customer> persistedCustomers = customerRepository.findAll();
        return persistedCustomers;
    }

    @GetMapping("/getCustomerByName")
    public Customer getCustomerByName(@RequestParam String name)
    {
        List<Customer> persistedCustomers = customerRepository.findAll();
        Customer customerList = null;
        for (Customer customer : persistedCustomers)
        {
            if (customer.getName().equals(name))
            {
                customerList = customer;
            }
        }
        return customerList;
    }

}
