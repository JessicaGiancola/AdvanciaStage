<%@page import="util.CRUDOperations"%>
<%@page import= "model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
	</head>
	<body>
	<% CRUDOperations crud = new CRUDOperations();
	crud.inizialitazion();
	%>
		<div>
			<a href="Login.jsp">Login</a>
			<a href="Register.html">Registrati</a>
		</div>
	</body>
</html>