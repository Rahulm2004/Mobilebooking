package com.mobilebooking.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobilebooking.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
