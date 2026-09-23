package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	
	//this is the second controller before this we will have a front controller 
	
	
    public HelloController() {
        System.out.println("HelloController object was created");
    }

	@RequestMapping("/hello")  //responds to the request mapped as /hello
	@ResponseBody  				//Becomes response body and sends the response
	public String sayhello() {
		return "<h1>Hello from Controller</h1>";
	}

	
	@RequestMapping("/sysdate")
	public String sysdate() {
		return "sysdate";
	}
	@RequestMapping("/Form")
	public String Form() {
		return "Form";
	}
}

