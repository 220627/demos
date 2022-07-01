package com.revature;

import com.revature.exceptions.MyCheckedException;

public class Launcher {

	public static void main(String[] args) throws MyCheckedException {
		
		System.out.println("==========================(Throwing Some Runtime Exceptions)");
		
		//We'll never purposefully throw a runtime exception... they usually asire due to faulty code
		
		System.out.println("Trying to divide by zero");
		
		//declare some variables to crash our code :(
		int i = 0;
		int i2 = 1;
		
		//this code will compile, but it will throw a RuntimeException
		//AT RUNTIME, java will attempt to perform this functionality, but we'll get an ArithmeticException
		//System.out.println(i2/i); 
		
		System.out.println("Trying to access an Array index that doesn't exist");
		
		int[] numbers = {0, 1, 2};
		
		//This code will call for index 3, but as we know this zero-indexed Array only has indices 0-2
		//Thus, an ArrayIndexOutOfBoundsException will be thrown
		//System.out.println(numbers[3]);
		
		System.out.println("====================================(Catching Exceptions with try/catch/finally)");
		
		try { //try will TRY a block of code that may or may not throw an exception.
			
			System.out.println("Try block starting...");
			
			int j = 5/0; //this WILL throw an ArithmeticException, and go straight to the appropriate catch block
			
			System.out.println("I won't print - once the Exception is thrown, the rest of the try block is skipped");
			
		} catch (NullPointerException e) { //Exceptions are objects, so java needs us to provide a variable name (e in this case)
			
			System.out.println("Will I run? NO!! A NullPointerException never gets thrown in the try block");
			
		} catch (ArithmeticException e) { //This is the exception that was thrown - its code will execute.
					
			System.out.println("Hello from the catch block - I caught an ArithmeticException");
			
		} catch (Exception e) {
			
			System.out.println("I could have caught any kind of exception...");
			
		} finally {
			System.out.println("Hello from the finally block - I will always run.");
		}
		//rule of thumb for catch blocks, you want the most specific ones first, and the most generic ones last
		//you can think of the generic Exception e catch as a catch-all block. it'll catch anything that slips through.
		
		System.out.println("===================================(Using my custom CheckedException");
		
		throwChecked();
		
		//we can either put this method call in a try/catch, or a throws in the main method
		//I'm going to opt for throws in the main method (which you shouldn't do because it will crash your program)
		
		//if we did a try/catch, we would put the method call in the try and catch a MyCheckedException or generic Exception
		
	} //end of the main method
	
	//creating a method that throws MyCheckedException
	//methods that throw CheckedExceptions will not let you compile unless you add the "throws" clause. 
	//by "throw"ing this exception, it makes the Exception handling the problem of the method that called it (main, in this case)
	public static void throwChecked() throws MyCheckedException {
		
		System.out.println("I'm about to throw a checked exception!");
		
		//the throw keyword is how we manually throw exceptions
		//Exceptions are OBJECTS (notice the "new" keyword), and we give it a String for its constructor (which takes a String).
		throw new MyCheckedException("our custom exception was thrown!!");
		
	}
	
	//remember, the compiler CHECKS for CheckedExceptions hence the name
	//so we need to handle them with a try/catch or throws clause before our application can run.
	
}
