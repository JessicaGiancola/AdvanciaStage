<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<div>
		<% System.out.println("parametro "+ request.getParameter("login"));  %>
		<%if (request.getParameter("login") != null) { %>
				<p>Username/Password errati</p>
				<% } %>
			<form action="Login" method="post">
				<p>Username <input type="text" name="username"></p>
				<p>Password <input type="password" name="password"></p>
				<p><input type="submit" value="Login"></p>
			</form>
			<a href="Register.html">Non sei registrato?</a>
		</div>
	</body>
</html>