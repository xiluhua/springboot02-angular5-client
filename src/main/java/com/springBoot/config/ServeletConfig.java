package com.springBoot.config;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springBoot.server.Filter1;
import com.springBoot.server.Listener1;
import com.springBoot.server.Servlet1;

@Configuration
public class ServeletConfig {
	
	@Bean
	public ServletRegistrationBean<Servlet> servlet1() {
		ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>();
		registrationBean.addUrlMappings("/servlet1");
		registrationBean.setServlet(new Servlet1());
		return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean<Filter> filter1() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.addUrlPatterns("/servlet1");
		registrationBean.setFilter(new Filter1());
		return registrationBean;
	}
	
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> listener1() {
		ServletListenerRegistrationBean<ServletContextListener> registrationBean = new ServletListenerRegistrationBean<>();
		registrationBean.setListener(new Listener1());
		return registrationBean;
	}
	
}
