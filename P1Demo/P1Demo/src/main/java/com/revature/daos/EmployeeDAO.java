package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Employee;

//DAO stands for Data Access Object - it's the layer of classes that DIRECTLY talk to the database
//so this is where any SELECT, INSERT, UPDATE, DELETE commands will go.
public class EmployeeDAO implements EmployeeDAOInterface {

	@Override
	public void insertEmployee(Employee employee, int role_id) {
		
		
		
	}

	@Override
	public ArrayList<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
