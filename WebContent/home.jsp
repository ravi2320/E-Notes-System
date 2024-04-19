<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<%@ include file="all_component/all_css.jsp"%>
</head>
<body>

	<%
		UserDetails user1 = (UserDetails)session.getAttribute("curr-user");
		if(user1 == null){
			response.sendRedirect("login.jsp");
			session.setAttribute("login-error", "Please Login...");
		}
	%>
	<div class="container-fliud">

		<%@ include file="all_component/navbar.jsp"%>
		<div class="card py-1 mb-3">
			<div class="card-body text-center">
				<img alt="bg" src="img/notes.png" class="img-fliud mx-auto" style="max-width:640px;">
				<h1>START TAKING YOUR NOTES</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>
	</div>

	<%@ include file="all_component/footer.jsp"%>
</body>
</html>