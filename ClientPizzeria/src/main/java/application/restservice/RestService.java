package application.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.Dough;
import model.Ingredient;
import soapservice.PizzeriaSoapServiceImpl;
import soapservice.PizzeriaSoapServiceImplService;

@Path("/")
public class RestService {
	
	@GET
	@Path("/pizzas")
	@Produces("application/json")
	public String getAllPizzas() {
		
		System.out.println("Raggiunto servizio");

		PizzeriaSoapServiceImplService serv = new PizzeriaSoapServiceImplService();
		PizzeriaSoapServiceImpl pizzeria = serv.getPizzeriaSoapServiceImpl();

		return pizzeria.getAll();
		  
	}
	
	@GET
	@Path("/dough")
	@Produces("application/json")
	public String getAllDoughs() {
		
		System.out.println("Raggiunto servizio");

		PizzeriaSoapServiceImplService serv = new PizzeriaSoapServiceImplService();
		PizzeriaSoapServiceImpl pizzeria = serv.getPizzeriaSoapServiceImpl();

		return pizzeria.getAllDough();
		  
	}
	
	@POST
	@Path("/adding")
	public boolean addIngredient(String i) {
		
		System.out.println("Raggiunto servizio " + i.toString());

		PizzeriaSoapServiceImplService serv = new PizzeriaSoapServiceImplService();
		PizzeriaSoapServiceImpl pizzeria = serv.getPizzeriaSoapServiceImpl();

		if (i.split("=")[1] != "") {
			Ingredient ing = new Ingredient();
			ing.setIngName(i.split("=")[1]);
			pizzeria.addIngredient(ing);
			return true;
		}
		
		return false;
	}
	
	@POST
	@Path("/adddough")
	public boolean addDough(String i) {
		
		System.out.println("Raggiunto servizio " + i.toString());

		PizzeriaSoapServiceImplService serv = new PizzeriaSoapServiceImplService();
		PizzeriaSoapServiceImpl pizzeria = serv.getPizzeriaSoapServiceImpl();

		if (i.split("=")[1] != "") {
			Dough d = new Dough();
			d.setType(i.split("=")[1]);
			pizzeria.addDough(d);
			return true;
		}
		
		return false;
	}

}
