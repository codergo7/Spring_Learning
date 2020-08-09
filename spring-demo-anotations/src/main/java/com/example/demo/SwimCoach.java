package com.example.demo;

public class SwimCoach implements Coach {
	
	private FortuneService theFortuneService;
	
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

}
