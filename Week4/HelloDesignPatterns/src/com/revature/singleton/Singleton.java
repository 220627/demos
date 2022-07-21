package com.revature.singleton;

//Using a singleton ensures that only one instance of this Class can ever exist
//This makes it so that all objects of the Class will be exactly the same
//Similar to how static members behave... it's kind of like making the entire Class static

//other big difference between singletons and normal classes:
//Normal classes use their constructors directly, while singletons use the getInstance() method
public class Singleton {

	//instantiate a private static object of the class, but leave it uninitialized 
	private static Singleton singleton;
	
	//declaring another variable just to demonstrate singleton functionality
	public String singletonMessage;
	
	//static method that creates a SINGLE instance of our Class
	public static Singleton getInstance() {
		
		if(singleton == null) { //if the singleton variable above is uninitialized...
			singleton = new Singleton(); //instantiate a new one!
		}
		
		//if the singleton exists already, the same one gets returned
		//thus, there will only ever be ONE instance of this class.
		return singleton;
		
	}
	
	//private constructor (so only the Singleton Class can see/use it)
	private Singleton() {
		super();
		singletonMessage = "I'm the only possible instance of this class";
	}
	
}
