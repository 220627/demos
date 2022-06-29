package com.revature;

//Imports go here... The Launcher Class can't see anything in com.revature.models unless we IMPORT
import com.revature.models.Person;
import com.revature.models.Pirate;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("============================(Using our constructors)");
		
		//Recall that we need constructors in order to initialize objects
		//I'm going to be initializing objects of the Person class. In other words, Person objects.
		
		//using the no-args constructor to create a Person object------------------------
		Person daniel = new Person();
		//Is this a reference variable or a primitive? Reference variable! Because it's REFERNCING an object
		
		//Let's print out the fields of this new Person object
		System.out.println(daniel.name);
		System.out.println("Daniel is " + daniel.gender + " and his hair is " + daniel.hairColor.toLowerCase());
		//.toLowerCase is a String method (Strings are objects...) that makes the String lowercase
		
		//we can also change the values of any object's variables
		daniel.hairColor = "Red";
		System.out.println("Daniel's new hair color is: " + daniel.hairColor);
		
		//using the all-args constructor (note, an argument for ALL Person variables is included)----------------------
		Person james = new Person("James Franco", "Brown", "Male");
		
		//Print out James Franco's variables
		System.out.println(james.name + " has " + james.hairColor + " hair and is " + james.gender);
		
		System.out.println("======================================(Using the methods)");
		
		//Instantiate a Pirate object 
		Pirate blackBeard = new Pirate();
		
		//printing out the Pirate's variables 
		System.out.println(blackBeard.name); // We get "Daniel" from the Person no args constructor
		System.out.println(blackBeard.dubloons); //We get 4500 from the Pirate no args constructor
		
		//Instantiate a Pirate object with all args
		Pirate redBeard = new Pirate("RedBeard", "Blonde", "Dude", 200000);
		
		//lets see the difference between the sleep() method of Pirate and Person
		System.out.println(daniel.sleep("YERRRRRRR"));
		System.out.println(redBeard.sleep("This String is never used in the Pirate sleep() method"));
		
		//Note the original sleep() functionality of the Person Class, followed by the overridden one of the Pirate Class
		
		//using the arggggggg() method of the Pirate Class
		System.out.println(redBeard.arggggggg());
		
		//could we call the arggggggg() method of a Person object?
		//NO!!!!!! because the Person Class doesn't have that method. It's unique to Pirate 
		
	}
	
}
