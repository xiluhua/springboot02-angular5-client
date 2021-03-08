package com.springBoot.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafB1Action {

	@RequestMapping("/b1.action")
	public String test(Map<String, Object> map) {
		System.out.println("b1 ...");
		map.put("name", "hi! 张三");
		map.put("id", "id1");
		map.put("uvalue", "<h1>Times</h1>");
		
		return "b1";
	}
	
}
