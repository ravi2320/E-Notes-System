<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
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

	<h1 class="text-center mt-3">Add Your Notes</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<form action="addNotesServlet" method="post">
				
					<%
						UserDetails us = (UserDetails) session.getAttribute("curr-user");
						if(us != null)
						{
					%>
					<input type="hidden" value="<%=us.getId()%>" name="uid">
					<%
						}
					%>
					<div class="form-group">
						<label for="exampleInputEmail1">Enter Title</label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter Title" name="title" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Enter Content</label>
						<textarea rows="9" cols="" class="form-control" name="content" required></textarea>
					</div>
					<div class="text-center mb-5"></a><button type="submit" class="btn btn-primary">Add Notes</button></div> 
				</form>

			</div>
		</div>
	</div>
	
	<%@ include file="all_component/footer.jsp"%>
</body>
</html>