package org.teipir.softeng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
	static Connection conn = null;
	public static Connection dbConnector(){
		
		
		try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String connectionURL = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "MyNewPass";
		Connection dbConnector= DriverManager.getConnection(connectionURL, username, password);
		return dbConnector;
		
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return conn;
	}
}
