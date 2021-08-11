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
		<title>Modifica la tua pizza</title>
	</head>
	<body>
	<% 
		CRUDOperations crud = new CRUDOperations();
	   	String pizzaID = request.getParameter("pizzaid");
	   	String userID = request.getParameter("userid");
	 	Pizza pizza = (Pizza) crud.findObj("Pizza", pizzaID);
	%>
		<div>
			<form action="ModifyPizza" method="post">
 				<input type="hidden" name="pizzaid" value="<%=pizza.getPizzaID()%>">
 				<input type="hidden" name="userid" value="<%=userID%>">
 				<div> 
					<label for="n">Modifica il nome della tua pizza</label>
 					<input type="text" name="name" id="n" value="<%=pizza.getPizzaName()%>">
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
 						<%if (dough.getType().equals(pizza.getDough().getType())){ %>checked <%}%>>
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
 						<input type="checkbox" id="<%= ing.getIngID() %>" name="ingredient" value="<%= ing.getIngID()%>"
 						<%if (pizza.getIngredients().contains(ing)){ %>checked <%}%>>
 						<label for="<%= ing.getIngID() %>"><%= ing.getIngName() %></label><br>
 					<%}%>
 				</div>
				<input type="submit" value="Crea la tua pizza">
			</form>
		</div>
	</body>
</html>