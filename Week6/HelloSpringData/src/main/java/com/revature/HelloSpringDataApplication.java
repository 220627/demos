package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.daos.PokemonDAO;
import com.revature.models.Pokemon;

@SpringBootApplication
public class HelloSpringDataApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringDataApplication.class, args);
	}

}
