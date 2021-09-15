package soapservice;


import javax.jws.WebMethod;
import javax.jws.WebService;

import model.Dough;
import model.Ingredient;

@WebService
public interface PizzeriaSoapService {

	@WebMethod public String getAll();
	@WebMethod public String getAllDough();
	@WebMethod public boolean addIngredient(Ingredient i);
	@WebMethod public boolean addDough(Dough d);
}
