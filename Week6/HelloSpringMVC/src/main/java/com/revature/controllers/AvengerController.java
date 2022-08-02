package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

@Controller //Makes the Class a Bean, and lets us use all of the annotations below
@RequestMapping(value="/avenger") //all requests ending in /mvc/avenger will go to this Controller
@CrossOrigin //this lets us take in HTTP Requests from anywhere (such as your front end)
@ResponseBody //This makes it so that every method in the Class will convert responses to JSON for us.
public class AvengerController {
		
	//we need an AvengerDAO object
	public AvengerDAO aDAO;

	//a constructor with the aDAO so we can use constructor injection
	//(this would be more important if this controller had some more object dependencies)
	@Autowired
	public AvengerController(AvengerDAO aDAO) {
		super();
		this.aDAO = aDAO;
	}

	//Declaring some methods that can take in HTTP Requests (no more Javalin, no more handlers here or in the main method)
	
	
	//get all avengers (this method will be called when the application gets a GET request to mvc/avenger)
	@GetMapping
	public List<Avenger> getAllAvengers(){
		return Arrays.asList(aDAO.getAll());
		//return the Avenger List to the frontend/postman. whatever called for it.
		//Arrays.asList is how we can turn Arrays into Lists
	}
	
	
	//BEN WILL POLISH THIS FOR ERROR HANDLING IN THE MORN'
	
	//get Avenger by ID (this method gets called when the application gets a GET request to /mvc/avenger/(some number)
	@GetMapping("/{id}") //here, we add a PATH VARIABLE, which will let us get the user's requested ID.
	public ResponseEntity<Avenger> getAvengerById(@PathVariable("id") int id){
		//@PathVariable will allow us to get the user-inputted path variable sent with the request (int id in this case)
		
		//get an Avenger object with the id path parameter that we extracted with @PathVariable
		Avenger avenger = aDAO.getById(id);
		
		//for now, we'll just return that avenger
		return ResponseEntity.status(200).body(avenger);
		//here, we're setting a status code of 200 (OK) and sending our Avenger in the response body
		
	}
	
	
}
