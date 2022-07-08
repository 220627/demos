package com.revature;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.daos.EmployeeDAO;

public class EmployeeDAOTest {

	@Test
	public void testGetEmployees() {
		
		EmployeeDAO eDAO = new EmployeeDAO();
		
		assertNotNull(eDAO.getEmployees());
		
	}
	
}
