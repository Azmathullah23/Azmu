package com.niit.backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Demo {
	
	static StudentDao obj; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		System.out.println("bean intialization");
		context.getBean("fact");
		System.out.println("got the bean successfully");

	}

}
