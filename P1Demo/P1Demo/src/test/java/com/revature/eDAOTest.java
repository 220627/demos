package com.revature;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.daos.EmployeeDAO;
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
	
}