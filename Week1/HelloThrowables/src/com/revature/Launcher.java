package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
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
		
	}
	
}
