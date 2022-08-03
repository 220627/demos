package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.PokemonDAO;
import com.revature.models.Pokemon;

@RestController //This annotation combines @Controller and @ResponseBody
@RequestMapping(value="/pokemon") //so now, every HTTP Request ending in /data/pokemon will go here
public class PokemonController {

	//I need to autowire a PokemonDAO 
	private PokemonDAO pDAO;

	//constructor injection - we couldn't instantiate a PokemonDAO otherwise, because it's an Interface
	@Autowired
	public PokemonController(PokemonDAO pDAO) {
		super();
		this.pDAO = pDAO;
	}
	
	
	//BEN WILL TALK ABOUT RESTTEMPLATE (server to server HTTP Requests)
	
	
	
	//MVC Methods to handle HTTP Requests-----------------------------------
	
	//insert pokemon - every POST request to /pokemon will go here
	@PostMapping
	public ResponseEntity addPokemon(@RequestBody Pokemon p) {
		
		//Thanks to @RequestBody, our Pokemon p parameter is filled with the incoming Pokemon data automatically
		//automatic JSON conversion :)
		
		//the save() method from our DAO is how we do INSERTs
		Pokemon newPoke = pDAO.save(p);
		
		//if insert failed....
		if(newPoke == null) {
			return ResponseEntity.badRequest().build(); //send a bad request status code, and no data
		}
		
		//if insert succeeded...
		return ResponseEntity.accepted().body(newPoke); //send an accepted status code, and the new Pokemon
		
	}
	
	
	
}
