package com.revature.models;

public class Role {

	private int role_id;
	private String role_title;
	private int role_salary;

	//boilerplate code------------------------------------------
	
	//no args constructor
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Role(int role_id, String role_title, int role_salary) {
		super();
		this.role_id = role_id;
		this.role_title = role_title;
		this.role_salary = role_salary;
	}

	//all args MINUS ID constructor. This is very common when INSERTing data with JDBC applications
	//these will come in handy when we need to INSERT more records, because role_id is handled by the serial datatype in the DB 
	public Role(String role_title, int role_salary) {
		super();
		this.role_title = role_title;
		this.role_salary = role_salary;
	}

	//remember, we need a toString to be able to print out Role objects
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_title=" + role_title + ", role_salary=" + role_salary + "]";
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_title() {
		return role_title;
	}

	public void setRole_title(String role_title) {
		this.role_title = role_title;
	}

	public int getRole_salary() {
		return role_salary;
	}

	public void setRole_salary(int role_salary) {
		this.role_salary = role_salary;
	}


	
	
}
