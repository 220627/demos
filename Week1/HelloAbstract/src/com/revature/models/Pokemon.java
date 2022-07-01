package com.revature.models;

//This is an Abstract Class, note the abstract keyword. It will also implement our Creature Interface
//So now, this abstract class also has access to the maxLevel variable and eat() method of the Creature Interface
//Abstract Classes are classes with AT LEAST one abstract method. 
public abstract class Pokemon implements Creature {

	//abstract classes can have variables
	public boolean fainted = false; //we'll give this a default value
	public int level = 5; //this value will be 5 by default
	
	//concrete method - has an implementation (aka method body)
	public void flee() {
		System.out.println("It Got Away!!!");
	}
	
	//abstract method - is unimplemented
	public abstract void fight(); //every unique Class that extends the Pokemon Abstract Class will need to implement this method.

	//another abstract method
	public abstract void gainLevel();
	
	
	//should I maybe add a constructor? the default no args constructor is here for now
	//and that should be sufficient because the variables here already have default values.
	
	//abstract classes can't be instantiated but they can have constructors? 
	//Yup, any subclasses will have access to them so they can still be used.

}
