package com.mobilebooking.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilebooking.demo.model.Login;
import com.mobilebooking.demo.repository.LoginRepository;

@Service
public class LoginService {

	   @Autowired
		LoginRepository lr;
	    
	    public List<Login> getDetails()
	    {
	    	return lr.findAll();
	    }
	    
	    public Login saveLogin(Login l)
		{
			return lr.save(l);
		}
	    
	    public String loginCheckData(String firstname,String password)
	    {
	    	Login user=lr.findByFirstname(firstname);
	    	if(user==null)
	    	{
	    		return "No user Found";
	    	}
	    	else
	    	{
	    		if(user.getPassword().equals(password))
	    		{
	    			return "Login Successful";
	    		}
	    		else
	    		{
	    			return "Login Failed";
	    		}	
	    	}
	    	
	    }
}
