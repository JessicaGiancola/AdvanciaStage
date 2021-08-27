<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
        <h1>Welcome <%=session.getAttribute("loginName")%> </h1>
      
        <h1>Student Information</h1>
        <form action="StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student ID</td>
                    <td><input type="text" name="studentId" value="${student.studentId}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstname" value="${student.firstName}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname" value="${student.lastName}" /></td>
                </tr>
               
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                
                </tr>            
            </table>
        </form>        
        <br>
        <table border="1">
        	<tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            </tr>
            
            <s:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentId}</td>
                    <td>${stud.firstName}</td>
                    <td>${stud.lastName}</td>                  
                </tr>
            </s:forEach>

        </table>  
 
    </body>
</html>