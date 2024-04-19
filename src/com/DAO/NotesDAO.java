package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.model.Notes;
import com.model.UserDetails;

public class NotesDAO {

	
	public boolean addNotes(String title, String content, int uid) {
		
		boolean flag = false;
		try {
			String query = "insert into notes(title, content, id) values(?, ?, ?)";
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, uid);
			
			int i = ps.executeUpdate();
			if(i > 0) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public List<Notes> getData(int id) {
		
		List<Notes> notes = new ArrayList<Notes>();
		
		try {
			String query = "select * from notes where id = ? order by nid DESC";
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Notes n = new Notes();
				n.setId(rs.getInt(1));
				n.setTitle(rs.getString(2));
				n.setContent(rs.getString(3));
				n.setPdate(rs.getDate(4));
				n.setUid(rs.getInt(5));
				notes.add(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return notes;
	}
	
	public Notes getNoteById(int id) {
		Notes note = null;
		try {
			String query = "select * from notes where nid = ?";
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				note = new Notes();
				note.setTitle(rs.getString(2));
				note.setContent(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return note;
	}
	
	public boolean editNotes(int id, String title, String content) {
		boolean flag = false;
		
		try {
			String query = "update notes set title = ?, content = ? where nid = ?";
			
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, id);
			
			int i = ps.executeUpdate();
			if(i == 1)
			{
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean deleteNotes(int id) {
		boolean flag = false;
		
		try {
			String query = "delete from notes where nid = ?";
			
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i == 1)
			{
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
