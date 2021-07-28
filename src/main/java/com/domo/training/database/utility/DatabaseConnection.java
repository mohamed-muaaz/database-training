package com.domo.training.database.utility;

import java.sql.*;

import com.domo.training.database.Properties;

public class DatabaseConnection {
	
	private static Connection conn = null;
	
	static {
        // SQLite connection
        try {
            conn = DriverManager.getConnection(Properties.DB_URL);
            System.out.println("Connection to SQLite has been established!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void close() {
		try {
			conn.close();
			System.out.println("Database connection disconnected!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
