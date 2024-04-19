<%@page import="java.util.List"%>
<%@page import="com.DAO.NotesDAO"%>
<%@page import="com.model.Notes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Notes</title>
<%@ include file="all_component/all_css.jsp"%>
</head>
<body>
	<%
	UserDetails user1 = (UserDetails) session.getAttribute("curr-user");
	if (user1 == null) {
		response.sendRedirect("login.jsp");
		session.setAttribute("login-error", "Please Login...");
	}
	%>
	<%@ include file="all_component/navbar.jsp"%>
	
	<%
		String success = (String) session.getAttribute("edit-success");
		if(success != null)
		{
	%>
		<div class="alert alert-success"><%=success %></div>
	<%
		}
		session.removeAttribute("edit-success");
	%>
	
	<%
		String fail = (String) session.getAttribute("edit-fail");
		if(fail != null)
		{
	%>
		<div class="alert alert-danger"><%=fail %></div>
	<%
		}
		session.removeAttribute("edit-fail");
	%>
	
	<%
		String deleteSuccess = (String) session.getAttribute("delete-success");
		if(deleteSuccess != null)
		{
	%>
		<div class="alert alert-success"><%=deleteSuccess %></div>
	<%
		}
		session.removeAttribute("delete-success");
	%>
	
	<%
		String deleteFail = (String) session.getAttribute("delete-fail");
		if(deleteFail != null)
		{
	%>
		<div class="alert alert-danger"><%=deleteFail %></div>
	<%
		}
		session.removeAttribute("delete-success");
	%>
	<div class="container">
		<h2 class="text-center">All Notes :</h2>

		<div class="row">
			<div class="col-md-12">

				<%
				if (user1 != null) {
					NotesDAO dao = new NotesDAO();
					List<Notes> notes = dao.getData(user1.getId());

					for (Notes note : notes) {
				%>

				<div class="card mt-3">

					<img alt="" src="img/notes.png" class="card-img-top mt-2 mx-auto"
						style="max-width: 300px">


					<div class="card-body p-4">

						<h5 class="card-title"><%=note.getTitle() %></h5>
						<p><%=note.getContent() %></p>

						<p>
							<b class="text-success">Published By: <%=user1.getName()%><br></b> <b
								class="text-primary"></b>
						</p>

						<p>
							<b class="text-success">Published Date: <%=note.getPdate()%><br></b> <b
								class="text-success"></b>
						</p>

						<div class="container text-center mt-2">
							<a href="DeleteServlet?note_id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
							<a href="edit.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Edit</a>
						</div>
					</div>
				</div>

				<%
				}
				}
				%>

			</div>
		</div>
	</div>
</body>
</html>