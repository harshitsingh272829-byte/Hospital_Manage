package com.hms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	 private static final String URL = "jdbc:postgresql://localhost:5432/hospitaldb";
	    private static final String USER = "postgres";   // change for MySQL
	    private static final String PASSWORD = "123";    // your password

	    public static Connection getConnection() {
	        Connection con = null;
	        try {
	            Class.forName("org.postgresql.Driver"); // for PostgreSQL
	            // For MySQL use: com.mysql.cj.jdbc.Driver
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }

}
