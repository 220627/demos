package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		//Using the Math Class to get a random number
		int randomNum = (int) (Math.random() * 100);
		//What is the (int) thing doing? This is Typecasting!
		//Just beware when you cast from a double to an int, the decimal is lost
		//Math.random() returns a double between 0.0 and 1.0. I don't want decimal places
		
		System.out.println(randomNum); 
		
		System.out.println("=====================================(If/Else If/Else)");
		
		if(randomNum > 75) {
			System.out.println("randomNum is real big"); //if randomNum > 75, this code block runs
		} 
		else if (randomNum > 50) {
			System.out.println("randomNum is midsized"); //if randomNum is less than 75, check if it's greater than 50
		}
		else {
			System.out.println("randomNum is real smol"); //if neither condition is met, the else block will run
		}
		
		System.out.println("======================================(while/do-while loops)");
		
		
		
	}
	
}
