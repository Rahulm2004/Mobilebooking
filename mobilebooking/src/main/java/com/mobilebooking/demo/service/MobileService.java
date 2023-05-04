package com.mobilebooking.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.mobilebooking.demo.model.Mobile;
import com.mobilebooking.demo.repository.MobileRepository;

import jakarta.transaction.Transactional;

@Service
public class MobileService {

	@Autowired
	MobileRepository mr;
	
	public  List<Mobile> getMobileDetails()
	{
		return mr.findAll();
	}
	
	public Mobile postMobile( Mobile s){
		return mr.save(s);
	}
	
	public Mobile putMobile( Mobile s){
		return mr.save(s);
	}
	
	public Mobile findMobile(int id)
	{
		return mr.findById(id).orElse(null);
	}
	
	public void deleteMobile( int id)
	{
		 mr.deleteById(id);
	}
	
	public List<Mobile> sortDetails(String field)
	{
		return  mr.findAll(Sort.by(field));
//		return  mr.findAll(Sort.by(Direction.DESC,field));
	}
	
	public List<Mobile> page(int offset,int pagesize)
	{
		Page<Mobile> paging=mr.findAll(PageRequest.of(offset,pagesize));
		return paging.getContent();
	}
	

	public List<Mobile> pagesort(int offset,int pagesize,String field)
	{
		Page<Mobile> paging=mr.findAll(PageRequest.of(offset,pagesize).withSort(Sort.by(field)));
		return paging.getContent();
	}
    
	public List<Mobile> getLapByBrandName(String prefix)
	{
		return mr.findByBrandnameStartingWith(prefix);
	}
	
	public List<Mobile> getByBrandName(String suffix)
	{
		return mr.findByBrandnameEndingWith(suffix);
	}
	
	public List<Mobile> getByPrice(int price)
	{
		return mr.findByPrice(price);
	}
	public List<Mobile> getByBrand(String brandname,String ram)
	{
		return mr.getByBrandname(brandname,ram);
	}
	public List<Mobile> getByModel(String modelname)
	{
		return mr.getByModelname(modelname);
	}
	
	@Transactional
	public int deleteBrandName(String brandname)
	{
		return mr.deleteByBrandname(brandname);
	}
	
	@Transactional
	public int updateModelname(String modelname,int modelid)
	{
		return mr.updateByModelname(modelname,modelid);
	}
 }
