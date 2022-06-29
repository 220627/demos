package com.revature;

public class Launcher {

	//This is a Class scoped primitive variable. *Note the "static", which makes it Class scoped (it belongs to the Class)
	//We will immediately assign the value 5 during declaration (in other words, we're initializing the variable) 
	public static int i = 5;
	
	//This is another Class scoped primitive, but we don't give it a value at declaration (it's uninitialized)
	public static int i2; //uninitialized ints will default to 0.
	
	//This is a Class scoped reference variable
	public static Launcher launcher; //uninitialized reference variables will default to null
	//why declare this with no constructor etc? think of it as reserving memory space for an object that MAY exist
	
	//This is an instance scoped variable. *Note the lack of the "static" keyword, which makes it instance scoped
	//Recall that instance scoped variables belong to each individual instance (each object in other words)
	double dub = 5.2; //it's initialized so all objects of the Launcher class will start with dub == 5.2
	
	/* Big Picture?
	 
	 Each instance of the Launcher Class will have its own specific value for the dub variable (instance scoped)
	 Each instance of the Launcher Class will share a value for i and i2 (class scoped)
	 
	 This is one of the main reasons we may or may no want to use the STATIC keyword
	 
	 //If you change the value of a static variable, that change will happen to all objects of the class
	 //If you change the value of a non-static variable, that change will only occur for the object you changed.
	 
	 */
	
	public static void main(String[] args) {
		
		System.out.println("========================================(Class & Instance Scoped Variables)");
		
		System.out.println(i); //should be 5 - it's initialized
		System.out.println(i2); //should be 0 - it's uninitialized
		
		//System.out.println(dub); 
		//Java won't like this - you cannot call non-static members in a static method
		
		//static members belong to the Class, so they CAN be access by other static members (like this one)
		//non-static members belong to INSTANCES of the Class (objects), so they aren't visible to static members
		
		//initializing the previously uninitialized primitive variable
		i2 = -98;
		
		//initializing the previously uninitialized reference variable
		launcher = new Launcher();
		
		System.out.println(i2); //this static primitive i2 has been changed to -98
		System.out.println(launcher); //we get a MEMORY ADDRESS. The location of the object in memory.
		
		//Since launcher was declared statically above this method, we can use it to access non-static variables
		//so with our launcher object, we can VIEW and CHANGE the dub variable for this Launcher object 
		System.out.println(launcher.dub);
		//Calling static objects with non-static variables is a way to access non-statics from within static methods
		
		System.out.println("========================================(Making a New Launcher Object");
		
		//Brand new Launcher object
		//launcher and launcher2 are the same data type (Launcher), but they are two different objects
		Launcher launcher2 = new Launcher();
		
		launcher2.dub = 12345.6; //giving launcher2 a new value for the non-static dub variable
		
		//dub is instance scoped, aka object scoped, aka nonstatic
		//so we can change the value of dub for launcher without affecting the value of dub in launcher2
		System.out.println(launcher.dub);
		System.out.println(launcher2.dub);
		
		launcher2.i2 = 5000;
		
		//i2 is class scoped, aka static
		//so any change to i2 in any object will be reflected amongst all objects
		System.out.println(launcher2.i2);
		System.out.println(launcher.i2);
		
		System.out.println("========================================================(Method/Block Scopes)");
		
		//call the scopesMethod() below
		scopesMethod();
		
	} //end of main method
	
	public static void scopesMethod() {
		
		double d = 25.50; //this is a method scoped variable - only visible within the method it's in
		
		if(d > 5) {
			
			double d2 = 30.50; //this is a block scoped variable - only visible within the if block
			
			System.out.println("Block Scoped Variable: " + d2);
			System.out.println("Method Scoped Variable: " + d);
			//variable d is visible in this if block since it's within the same method
			
		}
		
		//System.out.println(d2);
		//d2 is only visible within the if block, since it was declared there.
	}
	
}
