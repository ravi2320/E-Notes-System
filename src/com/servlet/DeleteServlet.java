package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.NotesDAO;
import com.model.Notes;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("note_id"));
		
		NotesDAO dao = new NotesDAO();
		boolean flag = dao.deleteNotes(id);
		
		HttpSession session = request.getSession();
		
		if(flag) {
			session.setAttribute("delete-success", "Record Deleted Successfully");
		}
		else
		{
			session.setAttribute("delete-fail", "Record not deleted...!");
		}
		response.sendRedirect("showNotes.jsp");
	}
}