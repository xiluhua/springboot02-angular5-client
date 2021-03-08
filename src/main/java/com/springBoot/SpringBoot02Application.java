package com.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = {"classpath:applicationContext.xml"})
@SpringBootApplication
public class SpringBoot02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02Application.class, args);
	}

}

