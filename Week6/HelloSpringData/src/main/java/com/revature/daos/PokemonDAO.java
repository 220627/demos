package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Pokemon;

//By extending JpaRepository, we get access to various DAO methods that we don't have to write ourselves
	//try to ctrl + click on JpaRepository to see the methods it provides

//JpaRepository takes two datatypes in its generic... (Pokemon, Integer in our case)
	//The first data type is the entity persisted (the class mapped to the database)
	//The second data type is the data type of the primary key (but as a wrapper class)

@Repository //We want this Interface to be a Spring Bean
public interface PokemonDAO extends JpaRepository<Pokemon, Integer>{

	//we had define this method signature, because JpaRepository doesn't have any method to find a pokemon by its name
		//Spring Data is smart, but it can't predict what our Classes or their variables will be
	//BUT Spring Data is smart enough to create this method body for us when given an abstract method
	public Optional<List<Pokemon>> findByName(String name);
	
	//HOW DOES THIS WORK???
	//By having a method name starting in "findBy" and ending in the variable you want to find!
	//and of course, we need a parameter to search for
	
	//NOTES: 
	//Spring needs your method name to be in camelCase, or it will throw vague errors
	//your variable names should not have underscores (or maybe google a way to have underscores)
	//make sure to call it findBy___ or it won't be recognized
	
	//there are a lot of options for custom methods, feel free to look into them
	
	//hypothetical login DAO method------------------------------------------------------
	
	//This would probably have to be in a UserDAO, or AuthDAO, anything related to Users... JpaRepository<User, Integer>
	//remember the generic in JpaRepository needs to reference a specific object
	
	/*
	public Optional<User> findByUsernameAndPassword(String username, String password);
	
	//since it's an optional, it'll either give you a User, or null
	//which of course, you can do some control flow on.
	//This particular method would only work if the variables were called username and password
	
	*/
	
}
