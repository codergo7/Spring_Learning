package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
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
		return "keep your body strong!";
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

}
