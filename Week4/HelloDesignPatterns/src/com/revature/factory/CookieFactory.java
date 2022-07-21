package com.revature.factory;

//Factories are one of the cleanest ways to achieve multi-object instantiation
//Imagine having 500 different types of cookies the user could possible make
//we can use a factory, paired with the Interface to abstract away the decision making code

public class CookieFactory {

	//a method that takes a string which determines what type of cookie to make
	public Cookie getCookie(String cookieType) {
		
		switch(cookieType) {
		
		case "snickerdoodle": 
			return new Snickerdoodle();
			//notice no need for breaks, since we're returning
			
		case "macadamia":
			return new Macadamia();
			
		case "doublechocolate":
			return new DoubleChoc();
			
		default: 
			System.out.println("no cookie found :(");
			return null;
		
		}
		
	}
	
}
