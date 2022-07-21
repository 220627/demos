package com.revature;

import com.revature.singleton.Singleton;

public class Launcher {
	
	public static void main(String[] args) {
		
		System.out.println("========================================(Singleton)");
		
		//create 3 instances of our Singleton Class (or maybe not...)
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();
		Singleton z = Singleton.getInstance();
		
		//print out the message of each variable
		System.out.println("x: " + x.singletonMessage);
		System.out.println("y: " + y.singletonMessage);
		System.out.println("z: " + z.singletonMessage);
		
		//change the message in instance x
		x.singletonMessage = "I'm different... but yet I stay the same";
		
		//print out the message for each instance again
		System.out.println("x: " + x.singletonMessage);
		System.out.println("y: " + y.singletonMessage);
		System.out.println("z: " + z.singletonMessage);
		
		//we see that changing one instance affects all the others...
		//technically, this is because they're all the same instance.
		
		//let me prove this further... they all have the same memory address
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);	
		
		System.out.println("========================================(Factory)");
		
		
		
		
		
		
	}

}
