package com.revature.models;

//This is an Interface, which contains fields and abstract methods
//It's meant to be implemented by Classes, which will take their abstract methods and implement them (give them a method body)
public interface Creature {

	//Interface variables are public, static, final by default. We don't have to specify them.
	int maxLevel = 100; //this variable is final, right? so every class that implements this interface will share the value.
	
	//Abstract method - no method body! AKA no implementation. public abstract by default.
	void eat(String food); //note the semicolon, not curly braces. No method body!
	
	
	//with the default keyword, we can write concrete methods in an interface
	//We won't usually do this, and I won't be actually using this method. Just wanna show it.
	default void someMethod() {
		//SOME CODE WOULD GO HERE
	}
	
}
