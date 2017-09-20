package com.ax.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String USER = "root";
	private static final String PASSWORD = "q1w2e3r4";
	private static final String URL = "jdbc:mysql://localhost:3306/axportal";
	
	public static Connection getConnection() throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		return connection;
	}
}
