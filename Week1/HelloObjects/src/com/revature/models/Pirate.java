package com.revature.models;

//Pirate extends Person!! So what? First of all, this is a primary example of INHERITANCE in java (a pillar of OOP)
//This means that the Pirate Class inherits all of the variables and methods of the Person class.
//BUT, it can also have its own variables and methods unique to the Pirate class
//Pirate is therefore a child class of Person (subclass/superclass relationship).
public class Pirate extends Person {

	//Pirate has all the variables and methods of the Person Class... but let's give it some unique members as well
	
	//This is a variable unique to the Pirate Class. Person has no dubloons :(
	public int dubloons;
	
	//This is a method unique to the Pirate Class. Person can't arggggg :(
	public String arggggggg() {
		return "ARGGGGGGGGG";
	}
	
	//method overriding - we are changing the implementation (the method body) of the sleep() method from Person
	
	//If we had not used Overriding, the Pirate Class would have the same exact sleep() method as the Person Class...
	//But here, we declare the same method signature (first line), with a different implementation (method body)
	//Why do we do this? So that the Pirate Class can have its own specific functionality for sleep().
	@Override
	public String sleep(String words) { //same method signature
		return "Pirates don't sleep they only plunder"; //different method body
		//NOTE that we didn't use the String parameter. This was mostly an oversight lol but good to show that it's legal
	}
	//note the @Override annotation, this is primarily for readability (we know this is definitely an override)
	//BUT it's also to enforce rules, this forces us to override sleep() in this Class

	
	//I need a constructor or two to instantiate (create) Pirate objects
	
	//Remember, having multiple constructors is an example of method overloading (same name, different parameters)
	
	//no-args constructor
	public Pirate() {
		super(); //This call to super() will call the no-args constructor of the superclass (Person)
		this.dubloons = 4500; //Person has no way to give a value to the dubloons variable, so we need to add it here
		//Note - super() is actually called inherently so we don't have to write
	}

	
	//all-args constructor (using the source -> generate constructor using fields)
	public Pirate(String name, String hairColor, String gender, int dubloons) {
		super(name, hairColor, gender); //This is a call to... the all args constructor of person!
		this.dubloons = dubloons;
	}
	
	//calls to super(); are known as constructor chaining - calling a constructor from within a constructor
	
}
