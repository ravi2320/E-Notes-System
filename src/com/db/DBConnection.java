package com.db;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.model.UserDetails;

public class DBConnection {
    private static Connection con = null;

    public static Connection getConnection() {
    	int i = 0;
        try {
            if (con == null) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "ravi2320");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
