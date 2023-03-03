package com.dev.sqlextractorservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerDAO customerDAO;

    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/customers")
    public List<Customer> allCustomers() {
        return customerDAO.getAllCustomers();
    }

    @GetMapping("/customers/{name}")
    public List<Customer> allCustomersByName(@PathVariable String name) {
        return customerDAO.getCustomersByName(name);
    }
}
