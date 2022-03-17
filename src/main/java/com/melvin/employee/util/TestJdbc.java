package com.melvin.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;

//class to test jdbc connection
public class TestJdbc {

	//main method to test connection to employeedb 
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/employeedb?useSSL=false&serverTimezone=UTC";
		String user = "melvin";
		String pass = "melvin";
		
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Successfull!");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}

