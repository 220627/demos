package com.revature.models;

import org.springframework.stereotype.Component;

@Component //@Component is the generic annotation for making a Class a Spring Bean, and storing it in the Spring Container
//Remember, the Spring Conatiner we use is ApplicationContext
public class Account {

	public double balance;
	public String type;
	
	
	//boilerplate code-----------------------------
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(double balance, String type) {
		super();
		this.balance = balance;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Account [balance=" + balance + ", type=" + type + "]";
	}
	
	
	
}
