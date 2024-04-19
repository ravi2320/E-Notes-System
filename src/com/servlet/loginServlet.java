package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.model.UserDetails;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");
		
		UserDetails udetail = new UserDetails();
		udetail.setEmail(email);
		udetail.setPassword(pass);
		
		UserDAO dao = new UserDAO();
		
		UserDetails user = dao.veifyUser(udetail);
		
		HttpSession session;
		
		if(user != null) {
			session = request.getSession();
			session.setAttribute("curr-user", user);
			response.sendRedirect("home.jsp");
		}
		else{
			session = request.getSession();
			session.setAttribute("login-fail", "Invalid Username Password...!");
			response.sendRedirect("login.jsp");
		}
	}

}
