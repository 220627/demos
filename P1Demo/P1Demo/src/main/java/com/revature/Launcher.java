package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.EmployeeController;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {
	
	
	public static void main(String[] args) {
		
		//****These aren't being used anymore, DAO methods are now called in the Controller layer
		//Instantiate an EmployeeDAO and RoleDAO so we can use their methods
		EmployeeDAO eDAO = new EmployeeDAO();
		RoleDAO rDAO = new RoleDAO();
		
		
		System.out.println("========Welcome to the Krusty Krab Employee Management System========");
		
		//this is a try-with-resources block. it will test whether our Connection works.
		//try-with-resources works by trying to open a certain resource (Connection in this case)
		//and catch an exception if the resource fails to open. 
		//So in this case, if we fail to open a connection, it will throw an exception
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) {
			//if the connection fails to open, catch the resulting SQLException and print the stack trace (error log)
			System.out.println("connection failed...");
			e.printStackTrace();
		} //end of the connection test
			
		
		//Typical Javalin syntax to CREATE a javalin object 
		Javalin app = Javalin.create(
				
				//the config lambda lets us specify certain configurations for our Javalin app.
				config -> {
					config.enableCorsForAllOrigins(); //this lets us process HTTP requests from any origin
				}
				
				).start(3000); //we need .start() to start our Java server on port 3000.
				//This port is important, because this is where we need to send requests to.
		
		//We need to make some endpoint handlers, which will take in requests and send them where they need to go
		//Javalin endpoint handlers are like a traffic cop to your Java server. They take HTTP traffic and direct it.
		
		//Instantiate an EmployeeController so that we can use its handlers
		EmployeeController ec = new EmployeeController();
		
		//endpoint handlers below--------------------------
		
		//app.get() is the javalin method that takes in GET requests. It will return all employees from the DB.
		//this handler takes in GET requests ending in /employees, and sends them to the getEmployeesHandler
		//the request in postman would look something like: localhost:3000/employees
		app.get("/employees", ec.getEmployeesHandler);
		//what does /employees relate to? it's something we define. we want requests ending in /employees to get all employees
		
		
		
	} //end of main method
	
}
