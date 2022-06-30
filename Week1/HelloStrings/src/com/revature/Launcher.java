package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("========================================(Strings are immutable)");
		
		String string = "I am immutable";
		
		//The String class has no methods that can directly change a String.
		//The best we can do is make new Strings by using methods on the original String
		
		string.toUpperCase(); //This WILL return the String in ALL CAPS, but it won't change the original String
		//this operation is still happening... but it's not getting saved anywhere etc.
		
		System.out.println(string); //"I am immutable"
		
		//BUT, we can assign a changed String to a new String object
		String newString = string.toUpperCase();
		
		System.out.println(newString); //"I AM IMMUTABLE"
		
		//we can also print out a String manipulation, but it still won't change the original String
		System.out.println(string.toUpperCase()); //"I AM IMMUTABLE"
		
		System.out.println(string); //"I am immutable"
		
		//This will also work, but we're not changing the actual value, we're reassigning a new value
		//We can't change a String's value, but we can make a String variable point to a different String
		string = string.toUpperCase();
		
		System.out.println(string); //"I AM IMMUTABLE"
	
		System.out.println("===============================(Testing String Equality)");
		
		String s1 = "Hi Java"; //This makes a new object in the String Pool (it's a String literal)
		String s2 = "Hi Java"; //This variable points to the same object created above
		//If we have two identical String literals, they will point to the same object to save space
		String s3 = "hi java"; //This makes a new object in the String Pool (it's not the same as "Hi Java"
		
		System.out.println(s1 == s2); //true, == compares memory address. s1 and s2 point to the SAME OBJECT
		System.out.println(s1.equals(s2)); //true, .equals() compares values, and s1 and s2 are identical
		System.out.println(s1 == s3); //false, == compares memory address. s1 and s3 are two different objects
		
		System.out.println(s1.toUpperCase() == s2.toUpperCase());
		System.out.println(s1.toUpperCase().equals(s2.toUpperCase()));
		
	}
	
}
