<%@page  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body >
   <form method="POST" action="LoginServlet">
      <table border="0">
      <tr>
      <td>Username</td>
      <td><input type="text" name="userName"></td>
      </tr>
      <tr>
      <td>Password</td>
      <td><input type="password" name="password"></td>
      </tr>
      <tr><td colspan="2" align="center">
              <input type="submit" value="Login"></td>
      </tr>
 </table>
   </form>
</body>
</html>