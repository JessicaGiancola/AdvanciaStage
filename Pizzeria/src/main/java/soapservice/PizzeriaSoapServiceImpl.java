package soapservice;


import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import model.DBInterface;
import model.Dough;
import model.Ingredient;
import model.Pizza;
import util.CRUDOperations;

@WebService(endpointInterface = "soapservice.PizzeriaSoapService")
public class PizzeriaSoapServiceImpl implements PizzeriaSoapService {

	@Override
	public String getAll() {
		List<Pizza> pizzas = new ArrayList<>();
		for(DBInterface pizza : new CRUDOperations().getAll("Pizza")) {
			pizzas.add((Pizza) pizza);
		};
		return pizzas.toString();
	}

	@Override
	public String getAllDough() {
		List<Ingredient> ings = new ArrayList<>();
		
		for(DBInterface ing : new CRUDOperations().getAll("Ingredient")) {
			ings.add((Ingredient) ing);
		};
		return ings.toString();
	}

	@Override
	public boolean addIngredient(Ingredient i) {
		new CRUDOperations().insertRecord(i);
		return true;
	}

	@Override
	public boolean addDough(Dough d) {
		new CRUDOperations().insertRecord(d);
		return true;
	}

}
