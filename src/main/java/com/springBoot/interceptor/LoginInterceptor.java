package com.springBoot.interceptor;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 登陆检查
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String servletPath  = StringUtils.defaultString(request.getServletPath()).trim().toLowerCase();
		String[] suffix 	= "css,js,jpg,png,svg,gif".split(",");
		for (String string : suffix) {
			if (servletPath.endsWith("."+string)) {
				return true;
			}
		}
		if (null != session.getAttribute("loginUser")) {
			return true;
		}
		request.setAttribute("error", "没有权限");
		request.getRequestDispatcher("/").forward(request, response);
		return false;
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}
}
