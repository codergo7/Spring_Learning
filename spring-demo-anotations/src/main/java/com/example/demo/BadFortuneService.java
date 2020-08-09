package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class BadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "You will be sick";
	}

}
