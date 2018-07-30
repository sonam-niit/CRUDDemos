package com.niit.jdbccrud.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	public static Connection getConnection()
	{
		Connection connection=null;
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/myDB1","sa","1234");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return connection;
	}
}
