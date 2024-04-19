<%@page import="com.model.Notes"%>
<%@page import="com.DAO.NotesDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Notes</title>
<%@ include file="/all_component/all_css.jsp"%>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>

	<%
		UserDetails user1 = (UserDetails)session.getAttribute("curr-user");
		if(user1 == null){
			response.sendRedirect("login.jsp");
			session.setAttribute("login-error", "Please Login...");
		}
	%>

	<%
		int noteId = Integer.parseInt(request.getParameter("note_id"));
	
		NotesDAO dao = new NotesDAO();
		Notes note = dao.getNoteById(noteId);
	%>
	<h1 class="text-center mt-3">Edit Your Notes</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<form action="EditNotesServlet" method="post">
				
				<input type="text" value="<%=noteId%>" name="nid">
					<div class="form-group">
						<label for="exampleInputEmail1">Edit Title</label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter Title" name="title"" value="<%=note.getTitle()%>">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Enter Content</label>
						<textarea rows="9" cols="" class="form-control" name="content"><%=note.getContent()%></textarea>
					</div>
					<div class="text-center mb-2"></a><button type="submit" class="btn btn-primary">Edit Notes</button></div> 
				</form>

			</div>
		</div>
	</div>
	
	<%@ include file="all_component/footer.jsp"%>
</body>
</html>