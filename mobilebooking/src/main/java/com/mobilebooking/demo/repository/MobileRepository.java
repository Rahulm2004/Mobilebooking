package com.mobilebooking.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.mobilebooking.demo.model.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile,Integer> {

	//position parameter
	@Query("select l from Mobile l where l.brandname=?1 and l.ram=?2")
	public List<Mobile> getByBrandname(String brandname,String ram);
	
	//named parameter
	@Query("select l from Mobile l where l.modelname=:modelname")
	public List<Mobile> getByModelname(String modelname);
	
	//DML
	@Modifying
	@Query("delete from Mobile l where l.brandname=?1")
	public int deleteByBrandname(String brandname);
		
		
	@Modifying
	@Query("update Mobile l set l.modelname=?1 where l.modelid=?2")
    public int updateByModelname(String modelname,int modelid);

	List<Mobile> findByBrandnameStartingWith(String prefix);
	List<Mobile> findByBrandnameEndingWith(String suffix);
	List<Mobile> findByPrice(int price);
}
