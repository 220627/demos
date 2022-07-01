package com.revature;

import com.revature.models.Chikorita;

public class Launcher {

	public static void main(String[] args) {
		
		//Instantiate a Chikorita object
		Chikorita chick = new Chikorita();

		//using the concrete flee() method from the Abstract Class
		chick.flee();
		
		//using the overridden abstract method from the Abstract Class
		chick.fight();
		
		//using the other overridden abstract method from the Abstract Class
		chick.gainLevel();
		//we didn't end up using the maxLevel variable from the Interface, but consider how we might be able to.
		//maybe an if/else in here that checks if the Pokemon's level is already 100. if true, don't level up.
		
		//using the overridden abstract method from the Interface
		chick.eat("berry");
		
		//we can also directly access the Abs Class and Interface fields
		System.out.println(chick.maxLevel);
		System.out.println(chick.fainted);
		
	}

}
