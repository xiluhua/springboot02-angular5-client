package com.springBoot.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.entity.Address;
import com.springBoot.entity.Customer;
import com.springBoot.service.impl.CustomerImpl;

@Controller
public class CustomerAction {

	@Autowired
	CustomerImpl customerImpl;
	
	@GetMapping("/customer/list.action")
	public String list(Map<String, Object> map) {
		int i = 0;
		if (i == 0) {
			throw new RuntimeException("/by zero3");
		}
		List<Customer> list = customerImpl.findAll();
		map.put("list", list);
		return "customer/list";
	}
	
	@GetMapping("/customer/go2add.action")
	public String go2add(Map<String, Object> map) {
		List<Address> list = customerImpl.findAllAddr();
		map.put("addresses", list);
		return "customer/add";
	}
	
	@GetMapping("/customer/go2update.action")
	public String go2update(@RequestParam("id") int id, Map<String, Object> map) {
		
		Customer customer = customerImpl.get(id);
		map.put("customer", customer);
		
		List<Address> list = customerImpl.findAllAddr();
		map.put("addresses", list);
		return "customer/add";
	}
	
	
	@PostMapping("/customer/add.action")
	public String add(Customer customer) {
		customerImpl.add(customer);
		return "redirect:/customer/list.action";
	}

	@PostMapping("/customer/update.action")
	public String update(Customer customer) {
		customerImpl.update(customer);
		return "redirect:/customer/list.action";
	}
	
	@PostMapping("/customer/delete.action")
	public String delete(@RequestParam("id") int id) {
		customerImpl.delete(id);
		return "redirect:/customer/list.action";
	}
	
}
