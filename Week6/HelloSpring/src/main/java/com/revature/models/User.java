package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //again, we want to make this Class a Bean
@Scope("prototype") //Giving this Bean prototype scope lets us have multiple instances (as opposed to a singleton)
public class User {

	public int id;
	public String name;
	public Account account;
	
	
	//boilerplate code--------------------------------------
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, Account account) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
	}

	//we created this constructor to accomplish CONSTRUCTOR INJECTION with Autowiring
	@Autowired //here, we're autowiring our Account Bean to our User Bean. 
	//what this accomplishes is the automatic (or automagic) instantiation of Accounts for each of our Users.
	public User(Account account) {
		super();
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + "]";
	}
	
	
}
