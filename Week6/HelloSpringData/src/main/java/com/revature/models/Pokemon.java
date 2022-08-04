package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//All of these annotations come from the JPA (The Java Persistence API)
@Entity //This annotation makes this class a DB table (or database entity in other words)
@Table(name="pokemon") //This annotation makes it so that our table will be named "pokemon" in the DB.
@Component //we want this Class to be a Spring Bean
public class Pokemon {

	@Id //This will make this variable the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This makes our PK serial
	private int poke_id;
	
	//non-id columns technically don't need the @Column annotation...
	//but it's good for clarity and if you need to set any constraints
	
	@Column(nullable = false) //now this column is not null
	private String name;
	
	@Column
	private String type;
	
	@Column
	private int level;

	//@ManyToOne relationship with the Trainer Class - one Trainer can have many Pokemon
	//We need to make this Trainer field a FK to the Trainer Table
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "trainerId") //THIS is how you specify the PK that this FK is referring to
	//the name attribute MUST be equal to the name of the id in the Trainer class (trainerId)
	//IMPORTANT NOTE: we can't use @Column here, because @JoinColumn already makes it a column
	private Trainer trainer;
	
	//what are fetch and cascade??? See the notes, small rundown here:
	
	/*
	  
	  fetch - sets whether we want the Trainer to be eagerly or lazily loaded.
	  			(we want eager loading so that the object is ready before we even need it)
	  			
	  cascade - sets how changes cascade. 
	  			with CascadeType.ALL, if a trainer is updated/deleted that update/delete will cascade automatically.
	 
	 */
	
	//boilerplate code--------------------------------------------------
	
	//no args
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args
	public Pokemon(int poke_id, String name, String type, int level, Trainer trainer) {
		super();
		this.poke_id = poke_id;
		this.name = name;
		this.type = type;
		this.level = level;
		this.trainer = trainer;
	}

	//all args minus id, we do this so that we can insert a new DB record 
	public Pokemon(String name, String type, int level, Trainer trainer) {
		super();
		this.name = name;
		this.type = type;
		this.level = level;
		this.trainer = trainer;
	}

	
	@Override
	public String toString() {
		return "Pokemon [poke_id=" + poke_id + ", name=" + name + ", type=" + type + ", level=" + level + ", trainer="
				+ trainer + "]";
	}

	public int getPoke_id() {
		return poke_id;
	}


	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public void setPoke_id(int poke_id) {
		this.poke_id = poke_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
}
