	package com.controllers;
	
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.Customer;
import com.services.CustomerService;
	
	@Controller
	public class CustomerController {
		
		
		@Autowired
		CustomerService customerservice;
		
		
		
	    @PostMapping("/registerCustomer")
	    public String registerCustomer(
	            @ModelAttribute("customer") Customer customer,
	            Model model) {

	        int rowsCreated =
	                customerservice.registerCustomer(customer);

	        model.addAttribute("customer", customer);
	        model.addAttribute("rowsCreated", rowsCreated);

	        System.out.println("Customer: " + customer);
	        System.out.println("Rows created: " + rowsCreated);

	        return "customer";
		
	
	
	}
	    

	    @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }
	    
	    @PostMapping("/login")
	    public String login(
	            @ModelAttribute("customer") Customer customer,
	            Model model) {

	        Customer loggedInCustomer =
	                customerservice.loginCustomer(customer);

	        if (loggedInCustomer == null) {
	            model.addAttribute("error", "Invalid email or password");
	            return "login";
	        }

	        model.addAttribute("customer", loggedInCustomer);
	        model.addAttribute("message", "Login successful");

	        return "customer";
	    }

	}