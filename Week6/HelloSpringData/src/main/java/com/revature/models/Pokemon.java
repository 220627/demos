package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	
	//boilerplate code--------------------------------------------------
	
	//no args
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args

	public Pokemon(int poke_id, String name, String type, int level) {
		super();
		this.poke_id = poke_id;
		this.name = name;
		this.type = type;
		this.level = level;
	}

	//all args minus id, we do this so that we can insert a new DB record 
	
	public Pokemon(String name, String type, int level) {
		super();
		this.name = name;
		this.type = type;
		this.level = level;
	}

	public int getPoke_id() {
		return poke_id;
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

	@Override
	public String toString() {
		return "Pokemon [poke_id=" + poke_id + ", name=" + name + ", type=" + type + ", level=" + level + "]";
	}
	
}
