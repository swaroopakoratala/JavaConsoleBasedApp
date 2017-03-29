package com.childdaycarecenter.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionmanager {
	
	private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";    
    private final static String driverName = "oracle.jdbc.driver.OracleDriver";   
    private final static String username = "Swaroopa";   
    private final static String password = "Swaroopa";
    private static Connection con;
    private static String urlstring;
    
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);   
                
            } catch (SQLException ex) {
                // log an exception. for example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}


