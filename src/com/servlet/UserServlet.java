package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.db.DBConnection;
import com.model.UserDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    public UserServlet() {
        super();
    }
	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");
		
		UserDetails udetail = new UserDetails();
		udetail.setName(name);
		udetail.setEmail(email);
		udetail.setPassword(pass);
		
		UserDAO dao = new UserDAO();
		
		int i = dao.addUser(udetail);

		PrintWriter pw = response.getWriter();
		
		HttpSession session;
		
		if(i == 1) {
			session = request.getSession();
			session.setAttribute("reg-success", "Registration Successful...");
			response.sendRedirect("register.jsp");
		}
		else {
			session = request.getSession();
			session.setAttribute("reg-fail", "Something went wrong on server...!");
			response.sendRedirect("register.jsp");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
