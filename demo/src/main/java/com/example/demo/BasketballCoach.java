package com.example.demo;

public class BasketballCoach implements Coach {
	
	private FortuneService fortune;
	
	public BasketballCoach(FortuneService fortune) {
		this.fortune=fortune;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run and jump!";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getDailyFortune();
	}

}
