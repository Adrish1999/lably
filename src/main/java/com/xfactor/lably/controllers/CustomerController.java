package com.xfactor.lably.controllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import com.xfactor.lably.entity.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{

    ArrayList<Customer> customers = new ArrayList<Customer>();

    @PostMapping("/registerCustomer")
    public Customer registerCustomer(@RequestBody Customer customer)
    {
        customers.add(customer);
        return customer;
    }

    @GetMapping("/getAllCustomers")
    public ArrayList<Customer> getAllCustomers()
    {
        return customers;
    }

    @GetMapping("/getCustomerByName")
    public Customer getCustomerByName(@RequestParam String name)
    {
        Customer customerList = null;
        for (Customer customer : customers)
        {
            if (customer.getName().equals(name))
            {
                customerList = customer;
            }
        }
        return customerList;
    }

}
