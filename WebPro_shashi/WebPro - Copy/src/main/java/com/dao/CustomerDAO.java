package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bean.Customer;

@Component
@Scope("prototype")
public class CustomerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
 

	public int registerCustomer(Customer customer) {
		
		String SQL = "INSERT INTO customer(first_name,last_name,email,password) VALUES (?, ?, ?, ?)";

		int rows= jdbcTemplate.update(SQL,customer.getFname(), customer.getEmail(),customer.getEmail(), customer.getPass());

		return rows;

	}


	public Customer loginCustomer(Customer customer) {

        String sql =
                "SELECT first_name, last_name, email, password " +
                "FROM customer " +
                "WHERE email = ? AND password = ?";

        List<Customer> customers = jdbcTemplate.query(
                sql,
                (resultSet, rowNumber) -> {

                    Customer loggedInCustomer = new Customer();

                    loggedInCustomer.setFname(
                            resultSet.getString("first_name"));

                    loggedInCustomer.setLname(
                            resultSet.getString("last_name"));

                    loggedInCustomer.setEmail(
                            resultSet.getString("email"));

                    loggedInCustomer.setPass(
                            resultSet.getString("password"));

                    return loggedInCustomer;
                },
                customer.getEmail(),
                customer.getPass()
        );

        if (customers.isEmpty()) {
            return null;
        }

        return customers.get(0);
    }	
	
	
	
}
