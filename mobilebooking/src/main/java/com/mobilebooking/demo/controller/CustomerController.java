package com.mobilebooking.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobilebooking.demo.model.Customer;

import com.mobilebooking.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	   @GetMapping("/getCustomer")
	    public List<Customer> getUserDetail()
	    {
	    	return cs.getUserDetail();
	    }
	    
	    
	    @PostMapping("/saveCustomer")
	    public Customer saveUserDetail(@RequestBody Customer u)
	    {
	    	return cs.saveUserDetail(u);
	    }

}
