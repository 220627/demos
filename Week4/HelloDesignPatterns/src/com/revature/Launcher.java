package com.revature;

import com.revature.factory.Cookie;
import com.revature.factory.CookieFactory;
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
		
		//Instantiate a CookieFactory so we can get some cookies
		CookieFactory cf = new CookieFactory();
		
		//use the getCookie method to bake some cookies
		Cookie c1 = cf.getCookie("snickerdoodle");
		Cookie c2 = cf.getCookie("macadamia");
		Cookie c3 = cf.getCookie("doublechocolate");
		
		//use the getBaked() method of each cookie
		c1.getBaked();
		c2.getBaked();
		c3.getBaked();
		
		
		//"This takes longer than if we just made new cookies... what's the point?
		
		//Realistically, you'd make factories when you have a bunch of concrete classes that are similar...
		//but with certain distinct values in their variables. 
		//This would be more helpful if the different cookie classes had a bunch of variables distinct to them
		
		
		
		
	}

}
