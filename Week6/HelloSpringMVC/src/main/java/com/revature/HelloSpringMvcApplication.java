package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = "com.revature")
public class HelloSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringMvcApplication.class, args);
	}

}
