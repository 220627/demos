package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
	//get all pokemon - every GET request to /pokemon will go here
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAllPokemon(){
		
		//no user inputs so this method will either work or it won't...
		//if it works, return a 200 (OK) status code, which lets us return a response body within it
		return ResponseEntity.ok(pDAO.findAll());
		
		//note the shorthand I'm using, I could have also done .ok().body(pDAO.findAll()) but why would I do that?
		
	}
	
	//get pokemon by id - every GET request to pokemon/byId/{some nunmber} will go here
	//the number given as the URL endpoint (which is the path variable) will be the ID we search by.
	@GetMapping(value="/byId/{id}")
	public ResponseEntity<Pokemon> findById(@PathVariable int id){
		
		//findById from JpaRepository returns an Optional...
		//Optionals lend to code flexibility because it may or may not have the object requested. It may be null.
		//this helps us avoid NullPointerExceptions
		
		//this is an Optional which potentially holds a Pokemon object
		Optional<Pokemon> pokeOptional = pDAO.findById(id);
		
		//we can check if the optional has data with .isPresent(), or not with .isEmpty()
		if(pokeOptional.isPresent()) {
			//we can get an Optional's data with .get()
			Pokemon p = pokeOptional.get();
			
			//return the Pokemon with a 200 status code and the pokemon data in the response body
			return ResponseEntity.ok(p);
			
		}
		
		//if the Optional is null (in other words if Optional.isPresent() == false)
		return ResponseEntity.noContent().build(); //return a no content status code, with empty response body
		
	}
	
	//Find by name - Any HTTP Request to pokemon/byName/{some String} will go here
	@GetMapping(value="/byName/{name}")
	public ResponseEntity<List<Pokemon>> findByName(@PathVariable String name){
		
		//not commenting this too heavily - it's very similar to the method above
		
		Optional<List<Pokemon>> pokeList = pDAO.findByName(name);
		
		
		//we had to do this, because even if the name doesn't exist, we'd get a empty List (which isn't null technically)
		//so we're checking here is the List itself is empty
		if(!pokeList.get().isEmpty()) {
			
			List<Pokemon> p = pokeList.get();
			
			return ResponseEntity.ok(p);
		}
		
		return ResponseEntity.noContent().build();
		
	}
	
	//a method that lets us get pokemon from the pokeAPI----------------
	
	//use RestTemplate to get a pokemon given their name
	public RestTemplate rt = new RestTemplate(); //with with, we can send HTTP Requests FROM OUR JAVA SERVER
	
	@GetMapping(value="api/{name}")
	public ResponseEntity<Pokemon> getPokemonFromApi(@PathVariable String name) {
		
		//.getForObject will send a GET request to the specified URL
		Pokemon externalPoke = rt.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class);
		
		//didn't do null checks here... hehe
		return ResponseEntity.ok(externalPoke);
		
	}
	
}
