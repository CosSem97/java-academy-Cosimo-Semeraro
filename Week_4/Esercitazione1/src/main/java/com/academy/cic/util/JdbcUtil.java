package com.academy.cic.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	
private static Connection connection;
	

	public static void initializeDriver(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
		}
	}
	
	// restituisce la connessione al DB students
	public static Connection getConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "javauser", "password");
		return connection;
	}
	
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}
	
	public static void closePreparedStatement(PreparedStatement pstmt) throws SQLException {
		if (pstmt != null) 
			pstmt.close();
	}
	
	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null)
			rs.close();
	}
	
}
