package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") //@Scope("prototype")
public class TennisCoach implements Coach {

	// define filed injection. >> no need setter method
	@Autowired
	@Qualifier("badFortuneService") // choose with @Qualifier annotation which object uses for injection
	private FortuneService fortuneService;

	/*
	 * // constructor injection
	 * 
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	// define default constructor for setter injection
	public TennisCoach() {

	}

	@Override
	public String getDailyWorkout() {
		return "Keep your body strong!";
	}
	

	/*
	 * // define a setter method for setter injection
	 * 
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}
	
	// defien init method
	
		@PostConstruct
		public void testPostConstructMedhod() {
			System.out.println("--->>> Intit method using @PostConstruct annotation");
		}
		
		// define destroy method
		//NOTE: For "prototype" scoped beans, Spring does not call the @PreDestroy method.
		
		@PreDestroy
		public void testPreDesyroyMedhod() {
			System.out.println( "--->>> destroy method using @PreDestroy annotation");
		}

}
