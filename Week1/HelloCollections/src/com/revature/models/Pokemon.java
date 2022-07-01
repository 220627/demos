package com.revature.models;

public class Pokemon {

	//variables for the Pokemon Class
	//I'm going to make these private, in order to achieve encapsulation (a pillar of OOP - read the bottom of our Java notes)
	private String name;
	private String type;
	
	//one method
	public void fight() {
		System.out.println(name + " attacked");
	}


	//constructors, getters and setters, and toString (boilerplate code)
	//boilerplate code is code you'll typically find in model classes. code that most model classes will have.
	
	//Spring tools makes generating boilerplate code very convenient - check out the source tab!
	
	//no-args constructors
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args constructor
	public Pokemon(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}


	//these are getters and setters - they let us view (get) and change (set) the private variables in our Pokemon objects
	//this is the other half of encapsulation - the main point is for data security
	//we don't want our variables/data to get manipulated accidentally or without our knowledge. 
	//By doing this, we ensure data can only be viewed via a getter and changed via a setter
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

	//toString lets us get objects printed out in String form (instead of memory address)
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + "]";
	}
	
}
