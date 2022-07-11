package com.revature;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.daos.EmployeeDAO;


public class eDAOTest {

	EmployeeDAO eDAO = new EmployeeDAO(); //moved this out here (I will forget I did this when we learn Mockito)
	
	@Test
	public void testGetEmployees() {
		
		assertNotNull(eDAO.getEmployees());
		
	}
	
}