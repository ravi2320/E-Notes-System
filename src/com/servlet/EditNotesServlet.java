package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.NotesDAO;

/**
 * Servlet implementation class EditNotesServlet
 */
@WebServlet("/EditNotesServlet")
public class EditNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("nid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NotesDAO dao = new NotesDAO();
		boolean flag = dao.editNotes(id, title, content);
		
		HttpSession session = request.getSession();
		if(flag)
		{
			session.setAttribute("edit-success", "Record Edited Successfully");
		}
		else 
		{
			session.setAttribute("edit-fail", "Record Not Edited");
		}
		response.sendRedirect("showNotes.jsp");
	}

}
