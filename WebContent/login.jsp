<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<%@ include file="all_component/all_css.jsp"%>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-5">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-circle fa-3x" aria-hidden="true"></i>
						<h4>Login</h4>
					</div>
					<% 
						String fail = (String) session.getAttribute("login-fail");
						if(fail != null)
						{
					%>
					<div class="alert alert-danger" role="alert"><%=fail%></div>
					<% 
						}
						session.removeAttribute("login-fail");
					%>
					
					<%
						String withoutLogin = (String) session.getAttribute("login-error");
						if(withoutLogin != null)
						{
					%>
					<div class="alert alert-danger" role="alert"><%=withoutLogin%></div>
					<%
						}
						session.removeAttribute("login-error");
					%>
					
					<%
						String logoutMsg = (String) session.getAttribute("logout-msg");
						if(logoutMsg != null)
						{
					%>
						<div class="alert alert-success"><%=logoutMsg %></div>
					<%
						}
						session.removeAttribute("logout-msg");
					%>
					<div class="card-body">
						<form action="loginServlet" method="post">
							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email" name="uemail">
							</div>
							<div class="form-group">
								<label>Enter Password</label> <input type="password"
									class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="upass">
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="all_component/footer.jsp"%>
</body>
</html>