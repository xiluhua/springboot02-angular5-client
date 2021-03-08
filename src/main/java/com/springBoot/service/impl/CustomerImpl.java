package com.springBoot.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springBoot.entity.Address;
import com.springBoot.entity.Customer;
import com.springBoot.service.CustomerService;

@Service
public class CustomerImpl implements CustomerService {
	
	public static Map<Integer, Customer> map = new HashMap<>();
	public static Map<Integer, Address> map2 = new HashMap<>();
	
	{
		Address address1 = new Address(1, "重庆");
		Address address2 = new Address(2, "北京");
		map2.put(address1.getId(), address1);
		map2.put(address2.getId(), address2);
		
		Customer customer1  = new Customer(1, "张三", 10);
		customer1.setIsBoss(true);
		customer1.setCreatedTime(new Date());
		customer1.setAddress(address1);
		map.put(customer1.getId(), customer1);
		for (int i = 2; i < 21; i++) {
			Customer customer2  = new Customer(i, "李四—"+(i), (10+i));
			customer2.setCreatedTime(new Date());
			if (i%2 == 0) {	
				customer2.setGender(2);
				customer2.setAddress(address2);
			}else {
				customer2.setGender(1);
			}
			map.put(customer2.getId(), customer2);
		}
	}
	
	public List<Customer> findAll(){
		List<Customer> list = new ArrayList<Customer>();
		list.addAll(map.values());
		return list;
	}
	
	public Customer get(int id){
		return map.get(id);
	}
	
	public List<Address> findAllAddr(){
		List<Address> list = new ArrayList<Address>();
		list.addAll(map2.values());
		return list;
	}

	@Override
	public int add(Customer customer) {
		customer.setId(map.size()+1);
		customer.setCreatedTime(new Date());
		map.put(customer.getId(), customer);
		String city = map2.get(customer.getAddress().getId()).getCity();
		customer.getAddress().setCity(city);
		return 1;
	}

	@Override
	public int update(Customer customer) {
		String city = map2.get(customer.getAddress().getId()).getCity();
		customer.getAddress().setCity(city);
		map.put(customer.getId(), customer);
		return 1;
	}

	@Override
	public int delete(int id) {
		map.remove(id);
		return 1;
	}
}
