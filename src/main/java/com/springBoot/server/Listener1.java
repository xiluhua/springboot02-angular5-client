package com.springBoot.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener1 implements ServletContextListener	 {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Listener1 ...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
