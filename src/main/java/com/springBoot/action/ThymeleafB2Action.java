package com.springBoot.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafB2Action {

	@RequestMapping("/b2.action")
	public String test(Map<String, Object> map) {
		System.out.println("b2 ...");
		map.put("uvalue", "<h1>Times</h1>");
		
		return "b2";
	}
	
}
