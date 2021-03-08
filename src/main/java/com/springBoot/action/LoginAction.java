package com.springBoot.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginAction {

//	@RequestMapping("/")
//	public String login() {
//		return "login";
//	}
	
	@PostMapping("/user/login.action")
	public String login(
			@RequestParam(value="name", required = false) String name, 
			@RequestParam(value="pswd") String pswd, 
			Map<String, Object> map,
			HttpSession session) {
		
		if ("aaa".equals(name) && "111".equals(pswd)) {
			session.setAttribute("loginUser", name);
			return "redirect:/main.action";
		}else {
			map.put("error", "登陆失败");
			return "login";
		}
	}
	
}
