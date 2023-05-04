package com.mobilebooking.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobilebooking.demo.model.Login;
import com.mobilebooking.demo.service.LoginService;



@RestController
public class LoginController {

	@Autowired
	LoginService ls;
	
	@GetMapping("/getlogin")
	public List<Login> getDetails()
	{
		return ls.getDetails();
	}
	@PostMapping("/checkLogin")
	public String LoginDetails(@RequestBody Login l)
	{
	    System.out.println(l.getFirstname());
		return ls.loginCheckData(l.getFirstname(),l.getPassword());
	}

	@PostMapping("/addLogin")
	public Login saveLogin(@RequestBody Login l)
	{
		return ls.saveLogin(l);
	}
}
