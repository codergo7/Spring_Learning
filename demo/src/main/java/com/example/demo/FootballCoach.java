package com.example.demo;

public class FootballCoach implements Coach {
	private FortuneService fortune;
	
	public FootballCoach() {
		// TODO Auto-generated constructor stub
	}
	
	public void setFortune(FortuneService fortune) {
		this.fortune = fortune;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run and shoot!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortune.getDailyFortune();
	}

}
