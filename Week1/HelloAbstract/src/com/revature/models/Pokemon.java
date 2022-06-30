package com.revature.models;

//This is an Abstract Class, note the abstract keyword. It will also implement our Creature Interface
//So now, this abstract class also has access to the maxLevel variable and eat() method of the Creature Interface
//Abstract Classes are classes with AT LEAST one abstract method. 
public abstract class Pokemon implements Creature {

	//abstract classes can have variables
	boolean fainted = false; //we'll give this a default value
	public String type; //this value will be null by default and filled in each unique pokemon object.
	
	//concrete method - has an implementation (aka method body)
	public void flee() {
		System.out.println("It Got Away!!!");
	}
	
	//abstract method - is unimplemented
	public abstract void fight(); //every unique Class that extends the Pokemon Abstract Class will need to implement this method.

}
