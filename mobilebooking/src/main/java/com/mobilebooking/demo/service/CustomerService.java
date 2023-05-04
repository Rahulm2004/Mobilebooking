package com.mobilebooking.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilebooking.demo.model.Customer;

import com.mobilebooking.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository cr;
	
	public List<Customer> getUserDetail()
	{
		return cr.findAll();
	}

	public Customer saveUserDetail(Customer u)
	{
		return cr.save(u);
	}
}
