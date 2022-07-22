package com.revature;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.*;
import org.mockito.stubbing.OngoingStubbing;
import static org.mockito.ArgumentMatchers.anyInt;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class eDAOTest {

	EmployeeDAO eDAO = new EmployeeDAO(); //moved this out here (I will forget I did this when we learn Mockito)
	
	@Test
	public void testGetEmployees() {
		
		assertNotNull(eDAO.getEmployees());	
		
	}
	
	@Test 
	public void testGetConnection() throws SQLException {
		
		assertNotNull(ConnectionUtil.getConnection());
		
	}
	
	@Test
	public void testInvalidConnectionCredentials() throws SQLException{
		
		//here we could call get connection directly from DriverManager with incorrect creds
		//and test for a SQLException to get thrown
		
	}
	
	
	//Let's use mockito to write some more powerful and potentially useful tests...
	
	
	//A test that makes sure inserting employees works
	@Test
	public void testInsertEmployee() {
		
		//spy() lets us create REAL objects that we can use with Mocks
		Employee mockEmployee = Mockito.spy(new Employee("name", "lastname", 3)); //an employee to insert
		EmployeeDAO mockDAO = Mockito.spy(new EmployeeDAO()); //a DAO to use the methods of
		
		//mock() lets us create FAKE objects that we don't have to fully instantiate.
		ArrayList<Employee> mockList = Mockito.mock(ArrayList.class);
		
		
		//get all employees, put the data into mockList, then verify that it worked
		mockList = mockDAO.getEmployees();
		Mockito.verify(mockDAO).getEmployees();
		
		//get the number of employees BEFORE inserting a new one
		int preInsert = mockList.size();
		
		//insert an employee, then verify that it worked
		mockDAO.insertEmployee(mockEmployee);
		Mockito.verify(mockDAO).insertEmployee(mockEmployee);
		
		//reassign mockList to the NEW list of employees
		mockList = mockDAO.getEmployees();
		
		//get the number of employees AFTER inserting a new one
		int postInsert = mockList.size();
		
		//actually call an assert method to test the above functionality
		assertTrue(preInsert < postInsert);
		
		//if the functionalities worked as intended, postInsert will be 1 number greater than preInsert.
		
	}
	
	//Test that getRoleById() method gets called when we getEmployees()
	@Test
	public void testGetRoleGetsCalled() {
		
		//we need a RoleDAO object to call its method
		RoleDAO mockRDAO = Mockito.spy(new RoleDAO());
		
		//.when() listens for a certain method to get called.
		//.thenReturn() lets us give a specific value for the method's return.
		OngoingStubbing<Role> r = Mockito.when(mockRDAO.getRoleById(anyInt())).thenReturn(new Role(0, "test", 0));
		
		//stubbing is basically waiting for a method to get called, and then automatically returning some value
		//an OngoingStubbing is an object that is instantiated as a result of stubbing
		//so we needed this here because .when() returns an object of type OngoingStubbing
		
		//also anyInt() and its cousing (anyString() etc) let us bypass the need for a real parameter
		
		//check if the role makes it in (which would imply that the method got called)
		assertNotNull(r);
		
	}

}