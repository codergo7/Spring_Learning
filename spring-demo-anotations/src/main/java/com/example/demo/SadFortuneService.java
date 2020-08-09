package com.example.demo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		
		return "Today is sad day";
	}

}
