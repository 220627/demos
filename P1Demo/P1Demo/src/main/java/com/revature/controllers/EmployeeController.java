package com.revature.controllers;

import com.revature.daos.EmployeeDAO;

import io.javalin.http.Handler;

//The Controller layer is where HTTP requests get sent after Javalin directs them.
//It's in this layer that we'll translate any JSON into Java and vice versa
//We'll either be getting data from the service or DAO layer to send back to the front end 
//OR we'll be receiving data from the front end to send to the database
public class EmployeeController {

	//We need an EmployeeDAO object to use its methods
	EmployeeDAO eDAO = new EmployeeDAO();
	
	//This Handler will get the HTTP GET Request for all employees, then collect the data and send it back in an HTTP Response 
	public Handler getEmployeesHandler = (ctx) -> {
	
		//what is ctx? it's the Context object! 
		//This object contains a bunch of method that we can use to take in HTTP Requests and send HTTP Responses
		
		
		
		
		
	}; //semicolon after curly brace? That's lambdas for you.

	

}
