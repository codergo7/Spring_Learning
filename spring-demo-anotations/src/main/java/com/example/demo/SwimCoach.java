package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService theFortuneService;
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;

	
	public SwimCoach() {
	}
	
	// method name is also Bean Id
	public SwimCoach(FortuneService fortuneService) {
		theFortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim swim swim!";
	}

	@Override
	public String getFortune() {
		
		return theFortuneService.getDailyFortune();
	}
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
