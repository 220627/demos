package com.revature.models;

public class StaticMethodClass {

	public static void testVisibility() {
		System.out.println("Hi I'm visible from within other static methods");
		System.out.println("If I was nonstatic we would need to instantiate a StaticMethodClass objects");
	}
	
}
