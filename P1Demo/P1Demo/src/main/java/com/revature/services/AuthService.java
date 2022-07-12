package com.revature.services;

import com.revature.daos.AuthDAO;

//The service layer is where we but any other business logic that doesn't deal with:
//parsing HTTP Requests and sending Responses (which is the job of the Controllers)
//talking to the database (which is the job of the DAOs)
//So in this case, we want to take in a LoginDTO, and determine if its values get a "true" returned from the DAO
//In a more fleshed out application, this class would create a new User object from the DAO and send it to the controller
public class AuthService {

	AuthDAO aDAO = new AuthDAO();
	
	public String login(String username, String password) {
		
		if(aDAO.login(username, password)) {
			return username; //if the username and password get a "true" from the DAO, send the username back.
		}
		
		return null; //if login fails, return null
		
	}
	
	//in a more complete application, we'd have a User Class with a bunch of variables that we'd instantiate here
	//but for now, we'll return the username
	
}
