package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.models.Avenger;

@SpringBootApplication
public class HelloSpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringAopApplication.class, args);
		
		//Make an Avenger object (we can see our @Before advices run here)
		Avenger a = new Avenger(10, "Frozone", "Freeze", "Lucious", "Best", 6000);
		
		
		
	}

}
