<%@page import="com.jsf.jpa.crud.SchoolEntityManager"%>
<%@page import="com.jsf.jpa.crud.SchoolBean"%>
<%@page import="com.jsf.jpa.crud.db.operations.DatabaseOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr> <th> id </th> <th> Name </th> </tr>
<% SchoolBean school = new SchoolBean();
for (Object s : school.schoolListFromDb()) { 
 SchoolEntityManager sc = (SchoolEntityManager) s;%>
<tr> <th><%=sc.getId() %> </th> <th><%=sc.getName() %> </th> </tr>
<%} %>

</table>
</body>
</html>