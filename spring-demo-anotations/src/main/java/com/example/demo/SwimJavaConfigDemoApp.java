package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		// get the bean from spring container
		Coach coach = context.getBean("swimCoach", Coach.class); //Bean id(swimCoach) is also method name in SportCongi.java
		
		// call a method on the bean
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getFortune());
				
		// call the getters of SwimCoach 
		SwimCoach swimCoach = (SwimCoach) coach;
		System.out.println("Email: " + swimCoach.getEmail());
		System.out.println("Team: " + swimCoach.getTeam());
		
		// close the context
		context.close();

	}

}
