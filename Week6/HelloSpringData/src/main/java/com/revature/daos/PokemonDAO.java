package com.revature.daos;

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

	
	
}
