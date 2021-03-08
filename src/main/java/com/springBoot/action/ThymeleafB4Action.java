package com.springBoot.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.entity.Customer;
import com.springBoot.service.impl.CustomerImpl;

@Controller
public class ThymeleafB4Action {

	@Resource
	CustomerImpl customerImpl;
	
	@RequestMapping("/b4.action")
	public String test(Map<String, Object> map) {
		System.out.println("b4 ...");
		List<Customer> list = customerImpl.findAll();
		map.put("list", list);
		
		return "b4";
	}
	
}
