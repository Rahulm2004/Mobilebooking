package com.mobilebooking.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mobilebooking.demo.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer>{

	Login findByFirstname(String firstname);
}
