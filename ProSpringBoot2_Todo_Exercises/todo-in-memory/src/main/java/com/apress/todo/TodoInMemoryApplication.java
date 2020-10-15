package com.apress.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoInMemoryApplication {
	//mvnw spring-boot:run
	public static void main(String[] args) {
		SpringApplication.run(TodoInMemoryApplication.class, args);
	}

}
