<%@page import="java.util.ArrayList"%>
<%@page import="util.CRUDOperations"%>
<%@page import= "model.*"%>
<%@page import="java.util.List"%>
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
	   String userID = request.getParameter("id");
	   if (userID == null){
		   response.sendRedirect("Login.jsp");
	   }
	%>
		<div>
			<form action="CreatePizza" method="post">
				<input type="hidden" name="userid" value="<%=userID%>">
				<div>
					<label for="n">Inserisci un nome per la tua pizza</label>
					<input type="text" name="name" id="n">
				</div>
				<div>
					<p>Seleziona l'impasto per la tua pizza:</p>
					<%
						List<DBInterface> doughs = crud.getAll("Dough");
						Dough dough;
						for (DBInterface d : doughs){
							dough = (Dough) d; 
					%>
						<input type="radio" id="<%= dough.getDoughID() %>" name="dough" value="<%= dough.getDoughID() %>" 
						<%if (dough.getType().equals("Impasto bianco")){ %>checked <%}%>>
						<label for="<%= dough.getDoughID() %>"><%= dough.getType() %></label><br>
					<%
						} 
					%>
				</div>
				<div>
					<p>Seleziona gli ingredienti che preferisci:</p>
					<%
						List<DBInterface> ings = crud.getAll("Ingredient");
						Ingredient ing;
						for (DBInterface i : ings){
							ing = (Ingredient) i; 
					%>
						<input type="checkbox" id="<%= ing.getIngID() %>" name="ingredient" value="<%= ing.getIngID()%>">
						<label for="<%= ing.getIngID() %>"><%= ing.getIngName() %></label><br>
					<%
						}
					%>
				</div>
				<input type="submit" value="Crea la tua pizza">
			</form>
		</div>
		
		<div>
		<%
			Pizza pizza;
			List<DBInterface> pizzas= new ArrayList<DBInterface>();
			pizzas = crud.getAll("Pizza", userID);
		%>
		
			<table style="width:100%; text-align:center">
			
				<tr><td colspan="5" align="center">Le mie pizze:</td></tr>
				<tr><td>Nome</td><td>Impasto</td><td>Ingredienti</td><td></td><td></td></tr>
				
				<%for(DBInterface p : pizzas){
					pizza = (Pizza) p;
				%>
				
				<tr><td><%=pizza.getPizzaName() %></td><td><%=pizza.getDough().getType() %></td><td>
				<%for(Ingredient i : pizza.getIngredients()){ %>
					<%=i.getIngName() %>
					<%}%> </td>
				<td><a href="ModifyPizza.jsp?pizzaid=<%=pizza.getPizzaID()%>&userid=<%=userID%>">Modifica</a></td><td><a href="DeletePizza?pizzaid=<%=pizza.getPizzaID()%>&userid=<%=userID%>">Elimina</a></td></tr><%} %>
			</table>

		
		</div>	
	</body>
</html>