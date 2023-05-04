package com.mobilebooking.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mobilebooking.demo.model.Mobile;
import com.mobilebooking.demo.service.MobileService;

@RestController
public class MobileController {

	@Autowired
	MobileService ms;
	
	@GetMapping("/getMobileDetails")
	public List<Mobile> getMobileDetails()
	{
		return ms.getMobileDetails();
	}
	
	@PostMapping("/postMobile")
	public Mobile postMobile(@RequestBody Mobile m)
	{
		return ms.postMobile(m);
	}
	
	@PutMapping("/putMobile")
	public Mobile putMobile(@RequestBody Mobile m)
	{
		return ms.putMobile(m);
	}
	
	@GetMapping("/findMobile")
	public Mobile findMobile(@RequestParam int id)
	{
		return ms.findMobile(id);
	}
	
	@DeleteMapping("/deleteMobile")
	public String deleteMobile(@RequestParam int id)
	{
		ms.deleteMobile(id);
		return "deleted";
	}
	
	@GetMapping("/sortDetails")
	public List<Mobile> sortDetails(@RequestParam String field)
	{
		return  ms.sortDetails(field);
	}
	
	@GetMapping("/page")
	public List<Mobile> page(@RequestParam int offset,@RequestParam int pagesize)
	{
		return  ms.page(offset,pagesize);
	}
	
	@GetMapping("/pagesort")
	public List<Mobile> pagesort(@RequestParam int offset,@RequestParam int pagesize,@RequestParam String field)
	{
		return  ms.pagesort(offset,pagesize,field);
	}
	
	@GetMapping("/prefix")
    public List<Mobile> getLapByBrandName(@RequestParam String prefix)
    {
    	return ms.getLapByBrandName(prefix);
    }
    
   
    @GetMapping("/suffix")
    public List<Mobile> getByBrandName(@RequestParam String suffix)
    {
    	return ms.getByBrandName(suffix);
    }
    
    @GetMapping("/price")
    public List<Mobile> getByPrice(@RequestParam int price)
	{
		return ms.getByPrice(price);
	}
    
    @GetMapping("/getbybrand")
    public List<Mobile> getByBrand(@RequestParam String brandname,@RequestParam String ram)
	{
		return ms.getByBrand(brandname,ram);
	}
    
    @GetMapping("/getlapbymodelname")
    public List<Mobile> getModel(@RequestParam String modelname)
    {
    	return ms.getByModel(modelname);
    }
    
    @DeleteMapping("/deletemobilebybrand")
    public String deletebrand(@RequestParam String brandname)
    {
    	int result= ms.deleteBrandName(brandname);
    	if(result>0)
    	{
    		return "Laptop detail deleted";
    	}
    	else
    	{
    		return "Problem occured while deleting";
    	}		
    }
    
    @PutMapping("/updatemobileModelname/{modelname}/{modelid}")
	public String updateModelname(@PathVariable String modelname,@PathVariable int modelid)
	{
	     int result= ms.updateModelname(modelname, modelid);
	     if(result>0)
	     {
	    	 return "Updated Successfully";
	     }
	     else
	     {
	    	 return "Problem occured while updating";
	     }
	}
    
}
