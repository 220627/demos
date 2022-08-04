package com.revature.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Trainer;

//Spring Data Interfaces ALWAYS extends JpaRepository
//it takes two generics - the object we're working with, and the data type of their primary key (wrapper class)
public interface TrainerDAO extends JpaRepository<Trainer, Integer> {

	//one custom method to facilitate login (finding a trainer by username & password)
	public Optional<Trainer> findByUsernameAndPassword(String username, String password);
	
}
