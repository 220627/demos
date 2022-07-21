package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		//Instantiate two new Threads so we can see multi-threading at work
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		
		//the start() method actually runs our Threads
		t1.start();
		t2.start();
		
		//what if we wanted each Thread to sleep for longer?
		//Best solution is probably make a variable in the Thread class, which you can set per object
		//or we could overload the run() method to take in an int for the sleep variable
		
		//make a couple new threads to see the order they run in
		MyThread t3 = new MyThread();
		MyThread t4 = new MyThread();
		
		t3.start();
		t4.start();
		
		//The order changes as they go! These threads are running concurrently, independent of each other
		
	}
	
}
