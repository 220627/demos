package com.revature.models;

//This concrete class extends the Pokemon Abstract Class
//Think of it as a more specific version of the more generic Pokemon Abstract Class
//Pokemon also implements Creature... so Chikorita inherits from both Pokemon AND creature. so it has access to all fields/methods
public class Chikorita extends Pokemon{

	//some variables unique to Chikoritas
	public String name = "Chikorita";
	public String type = "Grass";
	
	//This is the eat method from the CREATURE INTERFACE
	@Override
	public void eat(String food) {
		System.out.println(this.name + " eats a " + food);
	}

	//This is the fight method from the POKEMON ABSTRACT CLASS
	@Override
	public void fight() {
		System.out.println(this.name + " used vine whip!!");
	}

	//This is the gainLevel method from the POKEMON ABSTRACT CLASS
	@Override
	public void gainLevel() {
		this.level++; //increment the level by 1
		System.out.println(this.name + " has grown to level: " + this.level);
	}

	//no-args constructor, thanks to super(); we call the default no-args constructor of Pokemon... Which calls the one from Object
	public Chikorita() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args constructor... we probably won't need this since every variable is initialized already
	//but all-args are always useful for user flexibility... Maybe they want to give a nickname to their Pokemon.
	public Chikorita(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	
	
}
