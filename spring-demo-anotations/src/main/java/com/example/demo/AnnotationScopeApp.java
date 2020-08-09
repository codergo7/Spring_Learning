package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeApp {

	public static void main(String[] args) {

		// load spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve objects  from spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// check whether the objects are same. 
		// default scope is 'singleton'. if scope is 'singleton', it is created one object.
		//if scope is 'prototype', it is created one object per request 
		
		// if scope is 'singleton', it will be printed 'true'.
		//if scope is 'prototype', it will be printed 'false'
		System.out.println(coach == theCoach);
		
		
		
		context.close();

	}

}
