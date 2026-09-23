package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bean.Customer;
import com.dao.CustomerDAO;


@Component
@Scope("prototype")
public class CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;

	public int registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
        return customerDAO.registerCustomer(customer);
	}
	
	public Customer loginCustomer(Customer customer) {
		
		
		return customerDAO.loginCustomer(customer);
	}

}
