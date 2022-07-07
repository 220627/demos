package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

//DAO stands for Data Access Object - it's the layer of classes that DIRECTLY talk to the database
//so this is where any SELECT, INSERT, UPDATE, DELETE commands will go.
public class EmployeeDAO implements EmployeeDAOInterface {

	@Override
	public void insertEmployee(Employee employee, int role_id) {
		
		//at the top of EVERY DAO METHOD, we need to open a database connection.
		try(Connection conn = ConnectionUtil.getConnection()){
			
		//First, we need out SQL String that represents the INSERT statement we want to send to the DB
		//There are variables here, and we can fill them out thanks to a PreparedStatement object
		//The question marks are how we indiciate that it's a value that we'll fill below
		String sql = "insert into employees (first_name, last_name, role_id_fk) values (?, ?, ?);";
			
		//Instantiate a PreparedStatement to fill in the variables of our SQL String (the ?s).
		//we use the prepareStatement() method from our Connection object to do this.
		PreparedStatement ps = conn.prepareStatement(sql);
			
		//fill in the values of our variables using ps.setXYZ()
		//these methods take two parameters - the variable we'll filling, and the value to fill it with
		ps.setString(1, employee.getFirst_name()); //by "1" here, we're referring to the first question mark in the SQL String.
		ps.setString(2, employee.getLast_name());
		ps.setInt(3, role_id); //will probably refactor this later to go through the Role object of Employee.
		
		//we've created the SQL String and filled it with data - now we need to EXECUTE THE STATEMENT!
		ps.executeUpdate(); //This is what actually sends our SQL off to the database.
		
		//Tell the user the insert was successful
		System.out.println("Employee " + employee.getFirst_name() + " was added!");
			
		} catch (SQLException e) { //if anything goes wrong, this SQLException will get thrown
			System.out.println("INSERT EMPLOYEE FAILED"); //tell the console we failed
			e.printStackTrace(); //print out the error log, which we'll need for debugging
		}
		
	} //end of insertEmployee()

	
	//BEN WILL TRY TO DEMONSTRATE TDD HERE
	@Override
	public ArrayList<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
