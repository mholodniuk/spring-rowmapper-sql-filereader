package com.dev.sqlextractorservice;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("rs = " + rs + ", rowNum = " + rowNum);
        return new Customer(
                rs.getInt("id"),
                rs.getString("name")
        );
    }
}
