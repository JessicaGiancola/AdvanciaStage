package util;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.DBInterface;
import model.Dough;
import model.Ingredient;
import model.Pizza;

@Path("/")
public class PizzeriaService {
	
	@GET
	@Path("/pizzeria/pizzas")
    @Produces("text/plain")
    public String getAllPizzas() {
		
		List<Pizza> pizzas = new ArrayList<>();
		for(DBInterface pizza : new CRUDOperations().getAll("Pizza")) {
			pizzas.add((Pizza) pizza);
		};
		return pizzas.toString();
    }
	
	@GET
	@Path("/pizzeria/ings")
    @Produces("text/plain")
	public String getAllIngredient(){
		
		List<Ingredient> ings = new ArrayList<>();
		
		for(DBInterface ing : new CRUDOperations().getAll("Ingredient")) {
			ings.add((Ingredient) ing);
		};
		return ings.toString();
	}
	
	@GET
	@Path("/pizzeria/doughs")
    @Produces("text/plain")
	public String getAllDough(){
		
		List<Dough> doughs = new ArrayList<>();
		
		for(DBInterface dough : new CRUDOperations().getAll("Dough")) {
			doughs.add((Dough) dough);
		};
		return doughs.toString();
	}
	
    @GET
    @Path("/pizzeria")
    @Produces("application/json")
    public String getPizzeria() {
                    String pattern = "{ \"pizzas\":\"%s\", \"ingredients\":\"%s\", \"doughs\": \"%s\"}";
                    return String.format(pattern, getAllPizzas(), getAllIngredient(), getAllDough());
    } 	
	
}
