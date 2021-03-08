package com.springBoot.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class HelloAction {

	@ResponseBody
	@RequestMapping("/hello.action")
	public String hello() {
		
		return "Hello world";
	}
	
//	@RequestMapping("/")
//	public String login() {
//		return "login";
//	}
	
}
