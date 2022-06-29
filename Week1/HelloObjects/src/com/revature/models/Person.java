package com.revature.models;

//This is a class meant to model a Person - you can think of it like a template/blueprint for all objects that are People
//It defines all the fields (variables) and methods (behaviors) that a Person can have

public class Person {

	//declaring some Person variables. We'll give them values with the constructors below
	public String name;
	public String hairColor; //this is camelCase. Variables with multi-word names will be written like this.
	public String gender;
	
	
	//declaring a method for the Person class. Think of this as something a Person can do
	public String sleep(String words) {
		return this.name + " sleeptalks: " + words;
	}
	//method disambiguation... this sleep() method is public so it's visible everywhere
	//it has a return type of String, so it must return a String
	//it takes one parameter called "words", which is what we'll return
	
	//constructors here-------------
	
	//These constructors are an example of **METHOD OVERLOADING**
	//They have the same name (Person) but different sets of parameters
	
	//no-args constructor. No args constructors have no arguments, hence the name
	//If you create a Person object without parameters, this constructor will be called.
	public Person() {
		this.name = "Daniel";
		this.hairColor = "Black";
		this.gender = "Male";
	}
	
	//all-args constructor. This constructor takes a parameter for EVERY variable in the class
	public Person(String name, String hairColor, String gender) {
		this.name = name;
		this.hairColor = hairColor;
		this.gender = gender;
		//this is confusing... why are we setting things equal to themselves?
		//trick question - we aren't!
		//this.name, this.hairColor etc are referring to the actual variables in the Class
		//we're saying the "name" variable in this Class will be equal to the "name" String parameter the user provides
	}

	
	//constructor talk-------------
	
	//Quick answer: constructors create (instantiate) our Objects by giving values to its variables
	//giving values to variables is also known as initialization 
	
	//Constructors look like methods with no return type (because methods will NEVER return anything)
	//Constructors will ALWAYS have the same name as the Class
	
	//Remember, constructors are special methods that let us instantiate (create) objects
	//They let us assign values to the object's variables. In this case, name, hairColor, gender
	
	//explain the "this" keyword in a constructor again?
	 
	/*

	the keyword 'this' refers to the object... so the variables referred to by "this" will be object's variable 
	and the other variables will be values that we pass

	 */
	
}
