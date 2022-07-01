package com.revature.exceptions;

//This is a checked exception (aka compile time exception), so we have to extend Exception
//If we wanted an unchecked exception (aka runtime exception), we would extend RuntimeException
public class MyCheckedException extends Exception {

	//constructor - This constructor calls the super constructor from Exception... 
		//which calls the super constructor from Throwable
	
	public MyCheckedException(String message) {
		super(message); //super calls the SUPER (parent class) constructor 
	}
	
	//So the whole point of this constructor is to return a String exception message (known as a stack trace)
	
}
