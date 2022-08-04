package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.TrainerDAO;
import com.revature.models.Trainer;

@RestController //makes a controller class a bean, and converts all HTTP Responses to JSON
@RequestMapping(value = "/trainer")
public class TrainerController {

	//inject and autowire the trainerDAO
	
	private TrainerDAO tDAO;

	@Autowired
	public TrainerController(TrainerDAO tDAO) {
		super();
		this.tDAO = tDAO;
	}
	
	
	//one method to take in Trainer login credentials
	//USUALLY we would make a LoginDTO out of the RequestBody, but for the sake of time we're just using a Trainer object
	@PostMapping
	public ResponseEntity<Trainer> login(@RequestBody Trainer t){
		
		//call the findByUsernameAndPassword method, using the values that the Trainer now has
		Optional<Trainer> optionalTrainer = tDAO.findByUsernameAndPassword(t.getUsername(), t.getPassword());
		
		//empty trainer to potentially get filled with the optional
		Trainer trainer;
		
		if(optionalTrainer.isPresent()) { //if login was successful...
			trainer = optionalTrainer.get(); //make a trainer object from the optional
			return ResponseEntity.accepted().body(trainer);//send the trainer back in the response
		}
		
		//if login failed... 
		return ResponseEntity.status(403).build(); //send a forbidden status code, with no reponse data.
		
	}
	
	
}
