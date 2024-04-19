package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.DBConnection;
import com.model.UserDetails;

public class UserDAO {
	
	public int addUser(UserDetails user) {
		int i = 0;
		try {
			String query = "insert into user1(name, email, password) values(?, ?, ?)";
			
			Connection con = DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			
			i = ps.executeUpdate();
			
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public UserDetails veifyUser(UserDetails udetail) {
		UserDetails user = null;
		try {
			String query = "select * from user1 where email = ? and password = ?";
			
			Connection con = DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, udetail.getEmail());
			ps.setString(2, udetail.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
