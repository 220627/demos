package com.revature;

//by extending the Thread class, this class is now a Thread and we can override the run() method
public class MyThread extends Thread {

	//we can now define whatever process we want this Thread Class to have
	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			
			//This String will be populated with the name of the current Thread we're in
			StringBuilder name = new StringBuilder(Thread.currentThread().getName());
			
			//append a working message to the end of our StringBuffer	
			name.append(" is working...");
			
			//print out the StringBuffer so that we can see the Threads working
			System.out.println(name);
			
			//Thread.sleep() forces a thread to wait x amount of milliseconds
			//this method potentially throws an exception, so we need this try/catch
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(Thread.currentThread().getName() + " finished!");
		
	} //end of run() method
	
}
