package com.springBoot.service;

import java.util.List;

import com.springBoot.entity.Address;
import com.springBoot.entity.Customer;

public interface CustomerService {
	public List<Customer> findAll();
	
	public Customer get(int id);
	
	public List<Address> findAllAddr();
	
	public int add(Customer customer);
	
	public int update(Customer customer);
	
	public int delete(int id);
}
