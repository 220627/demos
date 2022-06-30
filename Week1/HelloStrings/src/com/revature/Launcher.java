package com.revature;

import java.util.Scanner;

public class Launcher extends Object {

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
		
		String s4 = new String("Hi Java"); //This will make a new object OUTSIDE of the string pool. 
		//Because the "new" keyword doesn't make a String literal. It puts it in the general heap
		
		//The absence or presence of the "new" keyword is what determines whether a String is a String literal
		
		System.out.println(s1 == s2); //true, == compares memory address. s1 and s2 point to the SAME OBJECT
		System.out.println(s1.equals(s2)); //true, .equals() compares values, and s1 and s2 are identical
		System.out.println(s1 == s3); //false, == compares memory address. s1 and s3 are two different objects
		System.out.println(s1.equals(s3)); //false, s1 and s3 have different values
		
		System.out.println(s1 == s4); //false, "new" creates a whole new object in memory (avoids String pool)
		System.out.println(s1.equals(s4)); //true, s1 and s4 hold identical values, despite them being different objects.
		
		//See why we use .equals() with Strings and other objects, and == with primtives?
		//== compares memory addresses of objects, which we usually don't want.
		//.equals() compares the actual values. So we'll always use .equals() to compare Strings.
		
		//5.equals(5); //This won't compile - primitives aren't objects so they don't have methods
		
		System.out.println("===================================(Using some String Methods)");
		
		//a pangram to use some String methods on
		String pangram = "Sphinx of Black Quartz, Judge my vow";
		
		//length() returns an int representing the length of the String
		System.out.println(pangram.length());
		
		//charAt() returns the char at a given index
		System.out.println(pangram.charAt(0)); //give us the first letter
		System.out.println(pangram.charAt(pangram.length() - 1)); //give us the last letter
		
		//subString() returns a String that's found within the given indices
		System.out.println(pangram.substring(5, 36)); //this INCLUDES the indices we put in
		
		//one more method - split() will create an Array via specified delimiters
		//we give the method some character to split up the String, and save it into an Array variable
		String[] words = pangram.split(" ");
		
		System.out.println(words); //this gives us a memory address... we want words!!
		
		//we'll use an enhanced for loop to print out the Array's contents
		for(String word : words) {  //"For every String in the Array (denoted by the "word" variable)... 
			System.out.println(word); //print it out
		}
		
		//how do enhanced for loops work? 
		//Basically, we perform some functionality for every element in the Array (or other data structure)
		
		System.out.println("==========================================(Using StringBuilder)");
		
		//Instantiate a new StringBuilder object. We can use our pangram String from earlier
		StringBuilder sb = new StringBuilder(pangram); //you can put any String value in the constructor here. I'm using pangram
		
		System.out.println(sb); //our StringBuilder now has the value of the pangram. Let's manipulate it below
		
		sb.reverse(); //reverse the StringBuilder
		sb.append("BENJAMIN"); //append (add) my name to the end of the SB
		sb.insert(12, "ELLIOTT"); //add "ELLIOTT" to index 12
		sb.delete(30, 35); //delete everything from indices 30-35
		sb.replace(0, 5, "Hello from the replace method"); //replace indices 0-5 with a new String
		
		System.out.println(sb); //print out whatever this is
		
		//Sometimes we need a String object (maybe a method you're using calls for a String)
		//We can use toString()!
		String newerString = sb.toString();
		
		System.out.println(newerString); //same value... but now in String form! (not StringBuilder)
		
		System.out.println("=============================================(Scanner)");
		
		//instantiate a Scanner objects so we can take user input
		Scanner scan = new Scanner(System.in); //System.in is how we tell the Scanner we're taking inputs from the console
		
		System.out.println("What's your name?"); //ask the user a question. They MUST answer.
		
		String name = scan.nextLine(); //the nextLine() method gathers a user input STRING and moves to the next line
		
		System.out.println(name + "? That's a lovely name");
		
		System.out.println("How old are you?");
		
		int age = scan.nextInt(); //nextInt() gathers an int from user input, but it doesn't make a new line...
		scan.nextLine(); //we need to explicitly call nextLine() in order for the user to answer any further questions
		//without nextLine() you can't gather any more user input.
		
		System.out.println("WHAT????? " + age + "??? You don't look a day over 95!!!");
		
		//fancy stuff with a while loop and a switch
		
		boolean showQuestion = true;
		
		//this while loop runs until the user answers correctly (Mudkip)
		while(showQuestion) {
		
		System.out.println("What is the best Pokemon starter?");
		
		String pokemon = scan.nextLine();
		
			//use a switch for this last user input
			switch(pokemon) {
			
			case "Mudkip":
				System.out.println("correct!");
				showQuestion = false; //this will break the while loop
				break;
				
			default:
				System.out.println("that is not correct");
			}
		
		}
		
	}
	
}
