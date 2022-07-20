package com.revature;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;
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
	
	
	@Test
	public void testInsertEmployees() {
		
		Employee e = new Employee("hi", "hello", 3);
		
		EmployeeDAO mockDAO = Mockito.spy(new EmployeeDAO());
		ArrayList<Employee> mockEmployees = Mockito.mock(ArrayList.class);
		
		mockEmployees = mockDAO.getEmployees();
		Mockito.verify(mockDAO).getEmployees();
		int preInsertCount = mockEmployees.size();
		
		mockDAO.insertEmployee(e);
		Mockito.verify(mockDAO).insertEmployee(e);
		
		mockEmployees = mockDAO.getEmployees();
		int postInsertCount = mockEmployees.size();
		
		assertTrue(preInsertCount < postInsertCount);
		
	}
	
	
}