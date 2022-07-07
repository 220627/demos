package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		
		
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
		}
		
	}
	
}
