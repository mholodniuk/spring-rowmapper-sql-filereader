package com.dev.sqlextractorservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO {

    @Value("#{fileReader.readFileToString('queries/selectAllCustomers.sql')}")
    private String selectAllCustomers;

    @Value("#{fileReader.readFileToString('queries/selectCustomersByName.sql')}")
    private String selectCustomersByName;

    private final JdbcTemplate template;
    private final CustomerRowMapper rowMapper;

    public CustomerDAO(JdbcTemplate template, CustomerRowMapper rowMapper) {
        this.template = template;
        this.rowMapper = rowMapper;
    }

    public List<Customer> getAllCustomers() {
        System.out.println(selectAllCustomers);
        return this.template.query(selectAllCustomers, rowMapper);
    }

    public List<Customer> getCustomersByName(String name) {
        System.out.println(selectCustomersByName);
        System.out.println(name);
        return this.template.query(selectCustomersByName, rowMapper, name);
    }
}
