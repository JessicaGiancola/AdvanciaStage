package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CRUDOperations;

/**
 * Servlet implementation class ModificaPizza
 */
@WebServlet("/ModifyPizza")
public class ModifyPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPizza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pizzaID = request.getParameter("pizzaid");
		String userID = request.getParameter("userid");
		String name = request.getParameter("name");
		String dough = request.getParameter("dough");
		String[] ings = request.getParameterValues("ingredient");
		
		CRUDOperations crud = new CRUDOperations();
		
		crud.UpdatePizza(pizzaID, name, dough, ings);
		
		response.sendRedirect("PizzaHome.jsp?id=" + userID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
