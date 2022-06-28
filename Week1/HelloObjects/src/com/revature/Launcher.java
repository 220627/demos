package com.revature;

//Imports go here... The Launcher Class can't see anything in com.revature.models unless we IMPORT
import com.revature.models.Person;

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
		
		//I almost forgot to use the sleep() method of the Person class
		System.out.println(daniel.sleep("YERRRRRRR"));
		
	}
	
}
