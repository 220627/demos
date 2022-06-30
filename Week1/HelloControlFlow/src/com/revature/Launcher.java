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
		
		
		int smallNum = 2; //declare a variable to use in our while loops
		
		//WHILE the expression in parenthesis evaluates to true, the code in the while loop will run
		while(smallNum < 500) {
			smallNum += 100;
			//we haven't seen += yet, it's basically shorthand for smallNum = smallNum + 100; (adding 100 to smallNum)
			//you can do this with any arithmetic operator. E.g. -=, *=, /=
			System.out.println("smallNum has increased to: " + smallNum);
		}
		
		//Why do we still get 502 printed? 402 < 500, we add 100 to 402 and print it out (502). Then the while loop breaks
		System.out.println("While loop has completed! Enjoy your new number");
		
		//DO-WHILE loops execute the code once, and THEN start checking if the evaluation () is true or false
		do {
			smallNum -= 100;
			System.out.println("smallNum has decreased to: " + smallNum);
		} while (smallNum > 10);
		
		System.out.println("Do-While loop has completed!");
		
		System.out.println("===============================================(For Loops)");
		
		//basic for loop
		
		int loopVictim = 0; //declaring an int which we'll use in the for loop
		
		//"for as long as this int i, which starts at 0, is less than 10, increment it once per loop.
		for(int i = 0; i < 10; i++) {
			
			//every time the for loop iterates (every time loops), this code will run
			
			loopVictim++; //increment loopVictim by 1
			System.out.println("our loopVictim is now: " + loopVictim);
			System.out.println("our loop variable (the iterator i) is now: " + i);
			//notice "our loop variable is now: 10" never prints, since the loop breaks once i is not < 10;
			//if we wanted, we could do i <= 10 in the expression to make it loop once more
			
		}
		
		//The loop executed 10 times (i = 0, 1, 2, 3... 9). Once i = 10, the expression is false and the loop breaks
		
		//More interesting use of for loops below
		
		//This is an Array, which we'll talk about tomorrow morning, but basically it's a list of values.
		char[] myName = {'B', 'E', ' ', 'N', 'Q', 'Q'};
		
		System.out.println(myName); //this isn't my name... I'm going to use a loop to print only the B E N.
		
		//"For as long as i is less than the length of the myName Array, run the block of code and increment i by 1"
		for(int i = 0; i < myName.length; i++) {
			
			//I want to loop through the Array, and only print out the letters in my name
			
			//"if the char at position i is equal to an empty space, skip this iteration of the for loop
			if(myName[i] == ' ' || myName[i] == 'Q') {
				continue; //continue causes the for loop to skip and move on to the next iteration
			} 
			
			//This print statement will only run if the condition in the if statement is false
			System.out.println(myName[i]);
			
		}
		
		System.out.println("=======================================(Switch Statement)");
		
		//declare a variable to use as our switch evaluation
		int age = 30;
		
		//depending on the value of the "age" variable, one of the following cases will run
		switch(age) {
		
		//each case is set to run certain code if age == the case
		//we need BREAK statements at the end of each case, or else every case under the one that executes will also run
		//break statements exit out of loops completely (whereas continue goes to the next loop)
		//there may be cases where you WANT every case to run after another - then, you'd leave out the break
		case 21:
			System.out.println("You are 21 years old");
			break;
		case 24: 
			System.out.println("You are 24 years old");
			break;
		case 22:
			System.out.println("You are 22 years old");
			break;
		default:
			System.out.println("Your age does not match any of the cases...");
			break;
			//the default case will run if none of the other cases above match the switch's argument (the age variable)
		}
		
	}
	
}
