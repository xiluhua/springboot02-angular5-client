package com.springBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springBoot.interceptor.LoginInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	/**
	 * Add Spring MVC lifecycle interceptors for pre- and post-processing of
	 * controller method invocations. Interceptors can be registered to apply
	 * to all requests or be limited to a subset of URL patterns.
	 * <p><strong>Note</strong> that interceptors registered here only apply to
	 * controllers and not to resource handler requests. To intercept requests for
	 * static resources either declare a
	 * {@link org.springframework.web.servlet.handler.MappedInterceptor MappedInterceptor}
	 * bean or switch to advanced configuration mode by extending
	 * {@link org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
	 * WebMvcConfigurationSupport} and then override {@code resourceHandlerMapping}.
	 */
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LoginInterceptor())
//		.addPathPatterns("/**")
//		.excludePathPatterns("/", "/hello.action","/index.html","/user/login.action")
//		.excludePathPatterns("/servlet1");
//	}
	
	/**
	 * Configure simple automated controllers pre-configured with the response
	 * status code and/or a view to render the response body. This is useful in
	 * cases where there is no need for custom controller logic -- e.g. render a
	 * home page, perform simple site URL redirects, return a 404 status with
	 * HTML content, a 204 with no content, and more.
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/b5").setViewName("b5");
		registry.addViewController("/").setViewName("login-view");
		registry.addViewController("/main.action").setViewName("dashboard");
		
		registry.addRedirectViewController("/index2", "login");
	}
}
