package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class Launcher {
	
	
	public static void main(String[] args) {
		
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
		
		
		//INSERT an employee using the insertEmployee() method in EmployeeDAO
		
		//Instantiate an Employee Object to insert
		//Employee newEmp = new Employee("Ben", "Fishman", null); //leaving Role as null for now (just using an int for RoleId)
		
		//call the insertEmployee() DAO method
		//eDAO.insertEmployee(newEmp, 2); //role 2 == Fry Cook
		
		
		//select a Role by id using the getRoleById() method
		System.out.println(rDAO.getRoleById(4));
		
		
	} //end of main method
	
}
