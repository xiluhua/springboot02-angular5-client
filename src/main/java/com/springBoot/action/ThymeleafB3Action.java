package com.springBoot.action;

import java.util.Arrays;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.service.impl.CustomerImpl;

@Controller
public class ThymeleafB3Action {

	@Resource
	CustomerImpl customerImpl;
	
	@RequestMapping("/b3.action")
	public String test(Map<String, Object> map) {
		System.out.println("b3 ...");
		map.put("users", Arrays.asList("张三","李四"));
		
		return "b3";
	}
	
}
